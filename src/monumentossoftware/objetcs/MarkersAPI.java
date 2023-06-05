package monumentossoftware.objetcs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.WaypointPainter;
import java.util.Set;


public class MarkersAPI extends DefaultWaypoint {
    private int id;
    private GeoPosition position;
    
    //Lista dos monumentos
    private static List<MarkersAPI> markers = new ArrayList<>();

    public MarkersAPI(GeoPosition position, int id) {
        super(position);
        this.position = position;
        this.id = id;
    }

    //Obter o ID associado ao marcador
    public int getId() {
        return id;
    }
    public static void DelMarker(int id) {
        System.out.println("Você antes tinha " + markers.size());
        for (int i = 0; i < markers.size(); i++) {
        MarkersAPI marker = markers.get(i);
        if (marker.getId() == id) {
            markers.remove(i);
            break; // Parar o loop após remover o marcador
            }
        }
        System.out.println("Agora você tem " + markers.size());
        
    }

    //Obter a posição do marcador
    public GeoPosition getPosition() {
        return position;
    }
    
    public void addMarketToList(MarkersAPI marker) {
        markers.add(marker);
    }
    
    
    private static void addMonumentsToMarkers() {
        markers.clear();
    for (Monument monument : Monuments.monumentMap.values()) {
        int id = monument.getId();
        double latitude = monument.getLatitude();
        double longitude = monument.getLongitude();
        GeoPosition positionmonument = new GeoPosition(latitude, longitude);
        MarkersAPI market = new MarkersAPI(positionmonument, id);
        markers.add(market);
        }
    }
    
    //Verificar se existe alguma localização na lista markers igual à localização do clickMouse do utilizador no mapa (em um raio de 0.0030)
    public static Integer getMatchingMarkerId(double latitude, double longitude) {
    double latitudeTolerance = 0.0030; // Tolerância de latitude para considerar que o clique foi no marcador
    double longitudeTolerance = 0.0030; // Tolerância de longitude para considerar que o clique foi no marcador

    for (MarkersAPI marker : markers) {
        double markerLatitude = marker.getPosition().getLatitude();
        double markerLongitude = marker.getPosition().getLongitude();

        if (Math.abs(latitude - markerLatitude) <= latitudeTolerance &&
            Math.abs(longitude - markerLongitude) <= longitudeTolerance) {
            return marker.getId(); // As coordenadas correspondem à posição do marcador
        }
    }

    return null; // Não encontrou nenhum marcador com coordenadas correspondentes
}

//Atualiza os marcadores dos monumentos no mapa
public static void loadMarkers(JXMapViewer view) {
    addMonumentsToMarkers(); // Atualiza a lista de marcadores

    Set<MarkersAPI> markersSet = new HashSet<>(markers);

    WaypointPainter<MarkersAPI> waypointPainter = new WaypointPainter<>();
    waypointPainter.setWaypoints(markersSet);

    view.setOverlayPainter(waypointPainter);
    view.repaint();
}
}


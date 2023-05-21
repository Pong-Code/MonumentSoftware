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

    //Obter a posição do marcador
    public GeoPosition getPosition() {
        return position;
    }
    
    public void addMarketToList(MarkersAPI marker) {
        markers.add(marker);
    }
    
    
    private static void addMonumentsToMarkers() {
    for (Monuments.Monument monument : Monuments.monumentMap.values()) {
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
    
    
    
    public void addMarker(GeoPosition position, int id) {
    MarkersAPI marker = new MarkersAPI(position, id);
    markers.add(marker);

    Set<MarkersAPI> markersSet = new HashSet<>(markers);

    WaypointPainter<MarkersAPI> waypointPainter = new WaypointPainter<>();
    waypointPainter.setWaypoints(markersSet);

    MapsAPI.view.setOverlayPainter(waypointPainter);
    MapsAPI.view.repaint();
}

public static void loadMarkers(JXMapViewer view) {
    if (markers.isEmpty()) {
        addMonumentsToMarkers();
    }
    Set<MarkersAPI> markersSet = new HashSet<>(markers);
    
    WaypointPainter<MarkersAPI> waypointPainter = new WaypointPainter<>();
    waypointPainter.setWaypoints(markersSet);

    view.setOverlayPainter(waypointPainter);
    view.repaint();
}
}


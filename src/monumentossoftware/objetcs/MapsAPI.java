
package monumentossoftware.objetcs;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import javax.swing.*;
import org.jxmapviewer.OSMTileFactoryInfo;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import monumentossoftware.interfaces.monuments.InsertMonuments;
import monumentossoftware.interfaces.monuments.ViewMonument;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.input.CenterMapListener;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;



public class MapsAPI extends JPanel {
    public static JXMapViewer view;
    public boolean mapLoaded = false;

    //Carrega o mapa
    public JXMapViewer loadMap() {
        //Verifica se o mapa já se encontra carregado
        if (!mapLoaded) {
            //Se não está carregado, cria um mapa novo
        System.out.println("Mapa criado com sucesso!!");
        TileFactoryInfo info = new OSMTileFactoryInfo();
        view = new JXMapViewer();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        view.setTileFactory(tileFactory);

        GeoPosition geo = new GeoPosition(41.2857325, -8.0413357);
        view.setAddressLocation(geo);
        //Setar o zoom na entrada da form
        view.setZoom(6);
       //Carregar marcadores simbolizando monumentos 
       MarkersAPI.loadMarkers(view);
        
        //Evento Andar pelo mapa, arrastando
        MouseInputListener mia = new PanMouseInputListener(view);
        view.addMouseListener(mia);
        view.addMouseMotionListener(mia);
        //Evento para centrar o mapa
        view.addMouseListener(new CenterMapListener(view));
        //Evento de zoom do mapa
        view.addMouseWheelListener(new ZoomMouseWheelListenerCenter(view));

        //Evento MouseClick(Left/Right)
        view.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    if(User.user.getRole().equalsIgnoreCase("explorador") || User.user.getRole().equalsIgnoreCase("admin")) {
                        InsertMonuments insertmonument = new InsertMonuments();
                        Point2D clickPoint = e.getPoint();
                        GeoPosition clickPosition = view.convertPointToGeoPosition(clickPoint);
                        Integer id = MarkersAPI.getMatchingMarkerId(clickPosition.getLatitude(), clickPosition.getLongitude());
                        if(id != null) {
                        JOptionPane.showMessageDialog(null, "Já existe um monumento nesse lugar!", "Erro ao adicionar", JOptionPane.ERROR_MESSAGE);
                        return;
                        }
                        InsertMonuments.loc = clickPosition;
                        insertmonument.show();
                        //Caso nao seja explorador
                    }else {
                        JOptionPane.showMessageDialog(null, "Você precisa ser explorador para adicionar monumentos!", "Sem permissão", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (SwingUtilities.isLeftMouseButton(e)) {
                    Point2D clickPoint = e.getPoint();
                    GeoPosition clickPosition = view.convertPointToGeoPosition(clickPoint);
                    Integer id = MarkersAPI.getMatchingMarkerId(clickPosition.getLatitude(), clickPosition.getLongitude());
                    if (id != null) {
                        Monument monument = Monuments.monumentMap.get(id);
                        VisitedProfilers profile = new VisitedProfilers();
                        int owner = monument.getOwner();
                        VisitedProfile profile1 = profile.getVisitedProfileById(owner);
                        ViewMonument viewmonument = new ViewMonument(monument.getId(), monument.getName(), monument.getYear(), monument.getDesc(), monument.getCountry(), monument.getPhoto(), profile1.getName(), profile1.getCreatedAtAsString(), profile1.getDesc(), profile1.getPhoto(), profile1.getId(), monument.getStatus());
                        viewmonument.setVisible(true);
                        viewmonument.show();
                    }
                }
              }
           });
        //Setar que o mapa foi carregado
        mapLoaded = true;
        }

        return view;
    }
    
    
    //Função para dar zoom em um monumento especifico pelo ID.
    public static void zoomToMonument(int monumentId) {
    Monument monument = Monuments.monumentMap.get(monumentId);
    if (monument != null) {
        double latitude = monument.getLatitude();
        double longitude = monument.getLongitude();
        GeoPosition position = new GeoPosition(latitude, longitude);
        view.setCenterPosition(position);
        view.setZoom(5); // Defina o nível de zoom desejado aqui
    }
    }
}
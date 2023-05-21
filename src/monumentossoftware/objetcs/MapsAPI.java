
package monumentossoftware.objetcs;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import javax.swing.*;
import org.jxmapviewer.OSMTileFactoryInfo;

import javax.swing.JPanel;
import monumentossoftware.interfaces.monuments.InsertMonuments;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.input.PanMouseInputListener;
import org.jxmapviewer.input.ZoomMouseWheelListenerCenter;
import org.jxmapviewer.viewer.DefaultTileFactory;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.TileFactoryInfo;



public class MapsAPI extends JPanel {
    
    public static JXMapViewer view;

    //Carrega o mapa
    
    public JXMapViewer loadMap() {
        TileFactoryInfo info = new OSMTileFactoryInfo();
        view = new JXMapViewer();
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        view.setTileFactory(tileFactory);

        GeoPosition geo = new GeoPosition(41.2857325, -8.0413357);
        view.setAddressLocation(geo);
        view.setZoom(6);
        
        MarkersAPI.loadMarkers(view);
        
        
        //Evento Andar pelo mapa, arrastando
        view.addMouseListener(new PanMouseInputListener(view));
        view.addMouseMotionListener(new PanMouseInputListener(view));
        //Evento de zoom no mapa
        view.addMouseWheelListener(new ZoomMouseWheelListenerCenter(view));

        view.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    System.out.println("1");
                    if(User.user.getRole().equals("explorador") || User.user.getRole().equals("admin")) {
                        InsertMonuments insertmonument = new InsertMonuments();
                        Point2D clickPoint = e.getPoint();
                        GeoPosition clickPosition = view.convertPointToGeoPosition(clickPoint);
                        InsertMonuments.loc = clickPosition;
                        insertmonument.show();
                        
                    }
                } else if (SwingUtilities.isLeftMouseButton(e)) {
                    Point2D clickPoint = e.getPoint();
                    GeoPosition clickPosition = view.convertPointToGeoPosition(clickPoint);
                    System.out.println("Clique no ponto: " + clickPosition);

                    Integer id = MarkersAPI.getMatchingMarkerId(clickPosition.getLatitude(), clickPosition.getLongitude());

                    if (id != null) {
                        System.out.println("Você clicou no marcador com ID: " + id);
                    }
                }
              }
           });

        return view;
    }
    
}





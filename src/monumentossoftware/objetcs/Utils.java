package monumentossoftware.objetcs;

import at.favre.lib.crypto.bcrypt.BCrypt;
import java.awt.Image;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import javax.swing.JComponent;
import javax.swing.JPanel;


/**
 *
 * @author chris
 */
public class Utils {
    
    public static boolean isValidEmail(String email) {
    // Define a expressão regular para validar o email
    String regex = "^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$";

    // Compila a expressão regular em um padrão
        Pattern pattern = Pattern.compile(regex);

    // Faz a correspondência do padrão com a string do email
        Matcher matcher = pattern.matcher(email);

    // Retorna se o email corresponde ao padrão
    return matcher.matches();
}
    
    public static String EncriptarPassword(String password) {
        String password2 = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        return password2;
}
    
    //Seta a imagem com as medidas certas, ou seja "reajusta" a imagem
    public static void setImageIcon(String path, JLabel component) {
    ImageIcon imagemIcon = new ImageIcon(Utils.class.getResource(path));
    Image imagemRedimensionada = imagemIcon.getImage().getScaledInstance(component.getWidth(), component.getHeight(), Image.SCALE_SMOOTH);
    component.setIcon(new ImageIcon(imagemRedimensionada));
    }
    
    public static void createGradientPanel(JPanel panel, Color color1, Color color2) {
    panel.setOpaque(false);
    panel.setBackground(new Color(0, 0, 0, 0));
    
    Color[] colors = new Color[] {
        color1,
        new Color((color1.getRed() * 2 + color2.getRed()) / 3, (color1.getGreen() * 2 + color2.getGreen()) / 3, (color1.getBlue() * 2 + color2.getBlue()) / 3),
        new Color((color1.getRed() + color2.getRed()) / 2, (color1.getGreen() + color2.getGreen()) / 2, (color1.getBlue() + color2.getBlue()) / 2),
        new Color((color1.getRed() + color2.getRed() * 2) / 3, (color1.getGreen() + color2.getGreen() * 2) / 3, (color1.getBlue() + color2.getBlue() * 2) / 3),
        color2
    };

    panel.setUI(new javax.swing.plaf.PanelUI() {
        @Override
        public void paint(Graphics g, JComponent c) {
            Graphics2D g2d = (Graphics2D) g;
            int width = panel.getWidth();
            int height = panel.getHeight();
            GradientPaint gradient = new GradientPaint(0, 0, colors[0], width, 0, colors[4]);
            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, width, height);
        }
    });
    panel.repaint();
    }






        
    
}

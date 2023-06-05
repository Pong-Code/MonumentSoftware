package monumentossoftware.objetcs;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class ImagesAPI {
    
    
    
    //Transformar uma imagem em uma String
    public static String encodeImageToBase64(File imageFile) {
    try {
        byte[] imageBytes = Files.readAllBytes(imageFile.toPath());
        return Base64.getEncoder().encodeToString(imageBytes);
    } catch (IOException e) {
        System.out.println("Erro ao codificar a imagem para Base64: " + e.getMessage());
    }
    return null;
    }
    
    
    //Transformar uma imagem em uma ImageIcon
    public static ImageIcon decodeBase64(String base64Code) {
        //Pegar uma imagem default
    ImageIcon defaultIcon = new ImageIcon(ImagesAPI.class.getResource("/images/icons/userdefault.png"));
    //Se o argumento for null ou for vazio, retorna a imagem default, senao cria uma ImagaeIcon pela String
    if (base64Code != null && !base64Code.isEmpty()) {
        try {
            byte[] imageBytes = Base64.getDecoder().decode(base64Code);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
            BufferedImage bufferedImage = ImageIO.read(bis);

            if (bufferedImage != null) {
                return new ImageIcon(bufferedImage);
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    return defaultIcon;
}

    
}

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
import java.util.Arrays;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;

public class Utils {
    public static String code = ""; // Onde fica guardado o code!
    private static String email = "historiavivasoftwarept@gmail.com";
    public static String emailuser = ""; // Onde fica guardado o email para onde vai ser enviado
    private static String emailpassword = "xvathklhjofocuot"; // Onde fica guardado o email!

    // Valida a entrada de emails
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

    // Encriptar a password
    public static String encriptarPassword(String password) {
        String password2 = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        return password2;
    }

    // Seta a imagem com as medidas certas, ou seja "reajusta" a imagem
    public static void setImageIcon(String path, JLabel component) {
        ImageIcon imagemIcon = new ImageIcon(Utils.class.getResource(path));
        Image imagemRedimensionada = imagemIcon.getImage().getScaledInstance(component.getWidth(), component.getHeight(), Image.SCALE_SMOOTH);
        component.setIcon(new ImageIcon(imagemRedimensionada));
    }

    //Faz o gradiente do meio da form de login/register
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

    // Função de enviar email!
    public static boolean sendRecoveryEmail(String recipientEmail, String recoveryCode) {
        Properties props = new Properties();

        // Obtém a senha da conta de email de uma variável de ambiente

        // Configura as propriedades do servidor SMTP do Gmail
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");

        // Cria a sessão de email
        Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(email, emailpassword);
                }
            });

        try {
            // Cria a mensagem de email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email)); // Remetente
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail)); // Destinatário(s)
            message.setSubject("Recuperação de senha"); // Assunto

            // Cria o corpo do email com HTML para formatação
            String htmlContent = "<div style='font-family: Arial, sans-serif;'>" +
                "<h3 style='color: #3498db;'>Recuperação de senha</h3>" +
                "<p>Olá,</p>" +
                "<p>Você solicitou a recuperação da senha da sua conta no nosso sistema. Use o código abaixo para recuperar sua senha:</p>" +
                "<div style='background-color: #f2f2f2; border: 1px solid #ccc; padding: 10px; font-size: 20px; font-weight: bold; text-align: center;'>" +
                recoveryCode +
                "</div>" +
                "<p>Obrigado por usar o nosso sistema!</p>" +
                "</div>";

            // Define o corpo do email como conteúdo HTML
            message.setContent(htmlContent, "text/html; charset=utf-8");

            // Envia a mensagem criada
            Transport.send(message);

            System.out.println("Email de recuperação de senha enviado com sucesso para: " + recipientEmail);
            return true;

        } catch (MessagingException e) {
            System.err.println("Erro ao enviar email de recuperação de senha para: " + recipientEmail);
            return false;
        }
    }

    // Verificar se a senha é válida (cumpre os requisitos)
    public static boolean isValidPassword(char[] password, char[] confirmPassword) {
        if (!Arrays.equals(password, confirmPassword)) {
            JOptionPane.showMessageDialog(null, "As senhas não são iguais!", "Senhas erradas", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (password.length < 5) {
            JOptionPane.showMessageDialog(null, "Por favor, crie uma senha com pelo menos 5 caracteres", "Senha inválida", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Gerar codigo enviado pelo email para recuperação de conta
    public static String gerarCodigo() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder codigo = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(letras.length());
            codigo.append(letras.charAt(index));
        }
        return codigo.toString();
    }

    // Verificar se um valor é um inteiro
    public static boolean isInteger(String input) {
        try {
            Integer.valueOf(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

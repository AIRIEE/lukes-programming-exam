import logging.AssignmentLogger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import javax.sound.sampled.*;
import exceptions.UnrecognizedCoffeeException;
import CoffeeType.Coffee;
import CoffeeType.Latte;
import CoffeeType.Americano;
import CoffeeType.Expresso;


public class CoffeeMachine extends JFrame {
    private JTextField coffeeInput;
    private JButton startButton;
    private JLabel messageLabel;
    private JComboBox<String> languageSelector;
    private JLabel coffeeImageLabel;
    private JLabel statusLabel;
    private ResourceBundle messages;
    private Locale currentLocale;

    public CoffeeMachine(Locale locale) {
        AssignmentLogger.logConstructor(this);
        currentLocale = locale;
        messages = ResourceBundle.getBundle("internationalization.MessagesBundle", locale);

        setTitle(messages.getString("coffee_machine"));
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        coffeeInput = new JTextField(15);
        coffeeInput.setToolTipText(messages.getString("input.tooltip"));

        startButton = new JButton(messages.getString("make_coffee"));
        messageLabel = new JLabel("");
        statusLabel = new JLabel("");
        statusLabel.setForeground(Color.RED);
        coffeeImageLabel = new JLabel();

        languageSelector = new JComboBox<>(new String[]{"English", "Español"});
        languageSelector.addActionListener(e -> switchLanguage());

        add(new JLabel(messages.getString("enter_coffee")));
        add(coffeeInput);
        add(startButton);
        add(languageSelector);
        add(statusLabel);
        add(messageLabel);
        add(coffeeImageLabel);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AssignmentLogger.logMethodEntry(this);
                String input = coffeeInput.getText().trim().toLowerCase();
                Map<String, Coffee> coffeeMap = new HashMap<>();
                coffeeMap.put(messages.getString("latte").toLowerCase(), new Latte());
                coffeeMap.put(messages.getString("americano").toLowerCase(), new Americano());
                coffeeMap.put(messages.getString("espresso").toLowerCase(), new Expresso());

                Coffee selectedCoffee = coffeeMap.get(input);

                if (selectedCoffee == null) {
                    JOptionPane.showMessageDialog(null, messages.getString("error.unrecognized"));
                    AssignmentLogger.logMethodExit(this);
                    return;
                }

                statusLabel.setText(messages.getString("status.preparing"));
                messageLabel.setText("");
                coffeeImageLabel.setIcon(null);

                new Thread(() -> {
                    try {
                        URL soundUrl = getClass().getResource("/sounds/" + selectedCoffee.getSoundFile());
                        AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundUrl);
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioIn);
                        clip.start();

                        Thread.sleep(selectedCoffee.getPreparationTime());

                        URL imageUrl = getClass().getResource("/images/" + selectedCoffee.getImageFile());
                        ImageIcon imageIcon = new ImageIcon(imageUrl);
                        coffeeImageLabel.setIcon(imageIcon);

                        messageLabel.setText(messages.getString("status.ready") + " " + selectedCoffee.getName());
                        statusLabel.setText("");

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }).start();
                AssignmentLogger.logMethodExit(this);
            }
        });

        setVisible(true);
    }

    private void switchLanguage() {
        AssignmentLogger.logMethodEntry(this);
        String selectedLang = (String) languageSelector.getSelectedItem();
        Locale newLocale = selectedLang.equals("Español") ? new Locale("es", "ES") : new Locale("en", "IE");
        dispose();
        new CoffeeMachine(newLocale);
        AssignmentLogger.logMethodExit(this);
    }
}


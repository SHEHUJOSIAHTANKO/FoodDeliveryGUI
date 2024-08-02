import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FoodDeliveryApp extends JFrame {

    private JPanel mainPanel;
    private File dataFile; // File for storing data

    public FoodDeliveryApp() {
        initializeFrame();
        setupPanels();
    }

    private void initializeFrame() {
        setTitle("Food Delivery to Hostels");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Center the frame on screen
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        getContentPane().add(mainPanel);
    }

    private void setupPanels() {
        mainPanel.add(new HostelPanel(this));
        mainPanel.add(new OrderPanel());
        mainPanel.add(new DeliveryPanel());
        mainPanel.add(new PaymentPanel());
        mainPanel.add(new FeedbackPanel());

        // Initialize file for data storage
        dataFile = new File("delivery_data.txt");
    }

    public File getDataFile() {
        return dataFile;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FoodDeliveryApp app = new FoodDeliveryApp();
            app.setVisible(true);
        });
    }
}

class HostelPanel extends JPanel {

    public HostelPanel(FoodDeliveryApp mainFrame) {
        setBorder(BorderFactory.createTitledBorder("Select Hostel"));
        JButton hostel1Button = new JButton("Hostel 1");
        JButton hostel2Button = new JButton("Hostel 2");

        hostel1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement hostel selection logic
                JOptionPane.showMessageDialog(null, "Selected Hostel 1");
            }
        });

        hostel2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement hostel selection logic
                JOptionPane.showMessageDialog(null, "Selected Hostel 2");
            }
        });

        add(hostel1Button);
        add(hostel2Button);
    }
}

class OrderPanel extends JPanel {

    public OrderPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Order Food"));

        // Example list of food items
        String[] foodItems = {"Pizza", "Burger", "Salad", "Pasta"};
        JList<String> foodList = new JList<>(foodItems);
        JScrollPane scrollPane = new JScrollPane(foodList);
        add(scrollPane, BorderLayout.CENTER);

        // Quantity selection
        JPanel bottomPanel = new JPanel();
        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityField = new JTextField(5);
        bottomPanel.add(quantityLabel);
        bottomPanel.add(quantityField);
        JButton addButton = new JButton("Add to Cart");
        bottomPanel.add(addButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}

class DeliveryPanel extends JPanel {

    public DeliveryPanel() {
        setLayout(new GridLayout(3, 1));
        setBorder(BorderFactory.createTitledBorder("Delivery Options"));

        // Time selection
        JPanel timePanel = new JPanel();
        timePanel.add(new JLabel("Delivery Time:"));
        JTextField timeField = new JTextField(15);
        timePanel.add(timeField);
        add(timePanel);

        // Delivery method selection
        JPanel methodPanel = new JPanel();
        methodPanel.add(new JLabel("Delivery Method:"));
        JComboBox<String> methodComboBox = new JComboBox<>(new String[]{"Standard", "Express"});
        methodPanel.add(methodComboBox);
        add(methodPanel);

        // Additional options (if needed)
        JPanel otherOptionsPanel = new JPanel();
        // Add more options here if necessary
        add(otherOptionsPanel);
    }
}

class PaymentPanel extends JPanel {

    public PaymentPanel() {
        setLayout(new GridLayout(4, 1));
        setBorder(BorderFactory.createTitledBorder("Payment Details"));

        // Credit card number input
        JPanel cardNumberPanel = new JPanel();
        cardNumberPanel.add(new JLabel("Card Number:"));
        JTextField cardNumberField = new JTextField(20);
        cardNumberPanel.add(cardNumberField);
        add(cardNumberPanel);

        // Expiry date input
        JPanel expiryPanel = new JPanel();
        expiryPanel.add(new JLabel("Expiry Date:"));
        JTextField expiryField = new JTextField(5);
        expiryPanel.add(expiryField);
        add(expiryPanel);

        // CVV input
        JPanel cvvPanel = new JPanel();
        cvvPanel.add(new JLabel("CVV:"));
        JTextField cvvField = new JTextField(3);
        cvvPanel.add(cvvField);
        add(cvvPanel);

        // Payment button
        JButton payButton = new JButton("Pay Now");
        add(payButton);
    }
}

class FeedbackPanel extends JPanel {

    public FeedbackPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Feedback"));

        // Feedback text area
        JTextArea feedbackArea = new JTextArea(10, 30);
        feedbackArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(feedbackArea);
        add(scrollPane, BorderLayout.CENTER);

        // Rating panel
        JPanel ratingPanel = new JPanel();
        ratingPanel.add(new JLabel("Rating (1-5):"));
        JSlider ratingSlider = new JSlider(JSlider.HORIZONTAL, 1, 5, 3);
        ratingSlider.setMajorTickSpacing(1);
        ratingSlider.setPaintTicks(true);
        ratingSlider.setSnapToTicks(true);
        ratingPanel.add(ratingSlider);
        add(ratingPanel, BorderLayout.SOUTH);
    }
}
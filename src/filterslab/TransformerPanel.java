package filterslab;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import org.opencv.core.Mat;

/**
 *
 * @author Darag
 */
public class TransformerPanel extends JPanel {

    private JLabel label;
    private ButtonGroup buttonGroup;
    private Transformer transformer[] = MainFrame.getTransformer();
    private final String filters[] = new String[transformer.length + 1];
    private JRadioButton buttons[] = new JRadioButton[transformer.length + 1];

    public TransformerPanel() {

        label = new JLabel("Transformation:");
        buttonGroup = new ButtonGroup();
        add(label);
        getNames();
        addRadioButtons();
    }

    private void getNames() {
        filters[0] = "None";
        int j = 1;
        for (int i = 0; i < transformer.length; i++) {
            filters[j] = transformer[i].getClass().getSimpleName();
            j++;
        }
    }

    private void addRadioButtons() {
        for (int i = 0; i < filters.length; i++) {
            buttons[i] = new JRadioButton(filters[i]);
            buttons[i].setFocusable(false);
            buttonGroup.add(buttons[i]);
            add(buttons[i]);
            buttons[i].addItemListener(new MyItemListener());
        }
        buttons[0].setSelected(true);
    }

    private String getSelectedButton() {

        String selected = "";
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].isSelected()) {
                selected += buttons[i].getText();
            }
        }
        return selected;
    }

    private class MyItemListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String buttonChecked = getSelectedButton();
                if (buttonChecked.equals("None")) {
                    MainFrame.setImage();
                } else {
                    for (int i = 0; i < transformer.length; i++) {
                        if (buttonChecked.equals(transformer[i].getClass().getSimpleName())) { // get class name 
                            Mat img = MainFrame.getImage();
                            MainFrame.setImageTransformed(img, transformer[i]);
                        }
                    }
                }
            }
        }

    }

}

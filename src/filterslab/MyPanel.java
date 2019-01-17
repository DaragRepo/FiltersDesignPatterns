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
public class MyPanel extends JPanel {

    private JLabel label;
    private ButtonGroup buttonGroup;
    private final Filter filter[] = MainFrame.getFilter();
    private final String filters[] = new String[filter.length + 1];
    private JRadioButton buttons[] = new JRadioButton[filter.length + 1];

    public MyPanel() {

        label = new JLabel("Filter:");
        buttonGroup = new ButtonGroup();
        add(label);
        getNames();
        addRadioButtons();
    }

    // get the names of the filters using class names and assign them to the filter array 
    private void getNames() {
        filters[0] = "None";
        int j = 1;
        for (int i = 0; i < filter.length; i++) {
            filters[j] = filter[i].getClass().getSimpleName();
            j++;
        }
    }

    // a loop for adding the radio buttons names dynamically using the filter names 

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

    // get the selected radio button

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
                    for (int i = 0; i < filter.length; i++) {

                        if (buttonChecked.equals(filter[i].getClass().getSimpleName())) { // gets the class name 
                            Mat img = MainFrame.getImage();
                            MainFrame.setImageFiltered(img, filter[i]);
                        }
                    }
                }
            }
        }

    }

}

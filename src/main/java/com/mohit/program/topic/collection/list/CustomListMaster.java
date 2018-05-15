package com.mohit.program.topic.collection.list;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mohit Soni on 15-05-2018.
 */
public class CustomListMaster {

    private final Map<String, ImageIcon> imageMap;
    private String imgSrc = "/";
    String[] nameList = {"m1", "m2", "m3"};
    Font font = new Font("helvitica", Font.BOLD, 24);

    public CustomListMaster() {
        imageMap = create(nameList);
        JList<String> jList = new JList<String>(nameList);
        jList.setCellRenderer(new CustomList());

        JScrollPane jScrollPane = new JScrollPane(jList);
        jScrollPane.setPreferredSize(new Dimension(300, 400));

        JFrame frame = new JFrame();
        frame.add(jScrollPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private Map<String, ImageIcon> create(String[] list) {
        Map<String, ImageIcon> map = new HashMap<>();
        for (String string : list) {
            String src = imgSrc + string + ".png";
            ImageIcon icon = new ImageIcon(getClass().getResource(src));
            map.put(string, icon);
        }
        return map;
    }

    public class CustomList extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                                                      boolean cellHasFocus) {
            JLabel jLabel = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            jLabel.setIcon(imageMap.get((String) value));
            jLabel.setHorizontalTextPosition(JLabel.RIGHT);
            jLabel.setFont(font);
            return jLabel;
        }
    }
}


package com.v360.view;

import java.awt.Dimension;

public class CommonConstants {
    public static final Dimension GUI_SIZE = new Dimension(611, 641);
    
    public static final Dimension BANNER_SIZE = new Dimension(GUI_SIZE.width, 50);

    public static final Dimension TASKPANEL_SIZE = new Dimension(GUI_SIZE.width - 30, GUI_SIZE.height - 175);
    
    public static final Dimension ADDTASK_BUTTON_SIZE = new Dimension(GUI_SIZE.width, 50);

    
    public static final Dimension TASKFIELD_SIZE = new Dimension((int)(TASKPANEL_SIZE.width * 0.70), 50);
    public static final Dimension SUBTASKFIELD_SIZE = new Dimension((int)(TASKPANEL_SIZE.width * 0.60), 50);
    public static final Dimension CHECKBOX_SIZE = new Dimension((int)(TASKFIELD_SIZE.width * 0.05), 50);
    public static final Dimension DELETE_BUTTON_SIZE = new Dimension((int)(TASKFIELD_SIZE.width * 0.12), 50);
    public static final Dimension ADD_SUBTASK_BUTTON_SIZE = new Dimension((int)(TASKFIELD_SIZE.width * 0.12), 50);
}
package com.mohit.program.util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImagingOpException;
import java.io.*;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by Mohit Soni on 15-05-2018.
 */
public class Global {
    public static int windowWidth = 0;
    public static int windowHeight = 0;

    public static int frameWidth = 0;
    public static int frameHeight = 0;

    public static final String APPNAME = "GoDiscount";
    public static final String ROOT = "C:/ProgramData/" + APPNAME + "/log/";
    public static final String cDir = System.getProperty("user.home") + "/";
    public static final String ParentDir = cDir + APPNAME + "/";
    public static final String PereferenceRootDir = "C:/ProgramData/" + APPNAME + "/";

    public static final String TempPereference = "C:/ProgramData/" + APPNAME + "/temp/";
    public static final String PereferenceDir = "C:/ProgramData/" + APPNAME + "/preference/";
    public static final String divider = "----------------x----------------";
    public static String SignInStatus = "";


    public static TrayIcon trayIcon;
    public final static SystemTray tray = SystemTray.getSystemTray();

    public static boolean OperationSnycing = false;
    private static String SystemTaskMassage = "Synced";
    public static boolean ShowNotification = true;

    private static final String base = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";


    // local variable
    public static String DATE = "";
    public static String ADD_CLASS_NAME = "";
    public static boolean isEditing = false;

    static String yr = "", day = "", month = "";

    static File system_root = new File(PereferenceRootDir);
    static File root = new File(ROOT);

    /**
     * log to console
     *
     * @param msg
     */
    public static void log(String msg) {
        System.out.println(msg);
    }

    /**
     * remove back slash from given string
     *
     * @param string
     * @return
     */
    public static String removeBackSlash(String string) {
        return string.replaceAll("\\\\", "/");
    }

    /**
     * get random number form temporary file
     *
     * @return
     */
    public static String getRandom() {
        Random random = new Random();
        return Integer.toString(random.nextInt(99999));
    }

    /**
     * set file/folder hidden
     *
     * @param tempPath
     */
    public static void setFileHidden(String tempPath) {
        try {
            Process builder = Runtime.getRuntime().exec("attrib +h " + tempPath);
            builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * set file/folder read only
     *
     * @param tempPath
     */
    public static void setFileReadOnly(String tempPath) {
        try {
            Process builder = Runtime.getRuntime().exec("attrib +h " + tempPath);
            builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * check Internet connection
     *
     * @return
     */
    public static boolean checkInternet() {
        try {
            return InetAddress.getByName("158.69.225.58").isReachable(20000);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * get external ip address
     *
     * @return
     */
    public static String getIP() {
        String ip = null;
        try {
            URL url = new URL("http://bot.whatismyipaddress.com/");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            ip = bufferedReader.readLine();
            bufferedReader.close();
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return ip;
    }

    /**
     * get current time in milli second
     *
     * @return
     */
    public static String getMilli() {
        return Long.toString(System.currentTimeMillis());
    }

    /**
     * get MD5 sum of string
     *
     * @param string
     * @return
     */
    public static String getMD5(String string) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bs = messageDigest.digest(string.getBytes());
            string = String.format("%032x", new BigInteger(1, bs));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return string;
    }


    /**
     * generate unique hash
     *
     * @return
     */
    public String getUniqueHash() {
        return getMD5(getMilli() + getRandom()) + getMD5(getMilli() + getRandom());
    }

    /**
     * delete path forcefully
     *
     * @param path
     */
    public static void deletePathForcely(String path) {
        if (path != null) {
            File root = new File(path);
            if (root.exists()) {
                try {
                    Process builder = Runtime.getRuntime().exec("cmd /c rd /s /q " + root.getAbsolutePath());
                    builder.toString();
                    log(path + ": Deleted successfully");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * add executable file detail to registry so that our program starts when windows starts
     *
     * @throws InterruptedException
     */
    public void addToRegistry() throws InterruptedException {
        String properties = System.getProperty("os.arch");
        if (properties.equals("amd64")) {
            try {
                String[] cmd = {"C:\\ProgramData\\GoDiscount\\auto64.bat", "-f"};
                Process p = Runtime.getRuntime().exec(cmd);
                p.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (properties.equals("x86")) {
            try {
                String[] cmd = {"C:\\ProgramData\\GoDiscount\\autox86.bat", "-f"};
                Process p = Runtime.getRuntime().exec(cmd);
                p.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * delete path forcefully
     */
    public void openRootDirectory() {
        //		try {
        //			Process builder = Runtime.getRuntime().exec("cmd /c start C:/Rigfiles/");
        //		} catch (IOException e) {
        //			e.printStackTrace();
        //		}

        try {
            Desktop.getDesktop().open(new File(ParentDir));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    /**
//     * get width
//     */
//    public Integer getWidth() {
//        Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
//        windowWidth = (int) dimen.getWidth();
//        windowHeight = (int) dimen.getHeight();
//
//        frameWidth = Global.windowWidth / 2 - 250;
//        frameHeight = Global.windowHeight / 2 - 250;
//
//        return Global.windowWidth - 350;
//    }
//
//    /**
//     * set height
//     */
//    public Integer getHeight() {
//        Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
//        windowWidth = (int) dimen.getWidth();
//        windowHeight = (int) dimen.getHeight();
//
//        frameWidth = Global.windowWidth / 2 - 250;
//        frameHeight = Global.windowHeight / 2 - 250;
//
//        return Global.windowHeight - 300;
//    }

//    /**
//     * indicate sync is going on
//     */
//    public static void SyncTray() {
//        trayIcon.setImage(new Global().createImage("res/icon_sync.png"));
//        SystemTaskMassage = APPNAME + " - in-sync";
//        trayIcon.setToolTip(SystemTaskMassage);
//    }
//
//    /**
//     * indicate sync is done
//     */
//    public static void DoneTray() {
//        trayIcon.setImage(new Global().createImage("res/icon_done.png"));
//        SystemTaskMassage = APPNAME + " - isynced";
//        trayIcon.setToolTip(SystemTaskMassage);
//    }


//    /**
//     * create system tray for sync done
//     */
//    public static void createSyncTray() {
//
//        if (!SystemTray.isSupported()) {
//            System.out.println("SystemTray is not supported");
//            return;
//        }
//        final PopupMenu popup = new PopupMenu();
//        trayIcon = new TrayIcon(new Global().createImage("res/icon_done.png"));
//
//
//        // Create a popup menu components
//        MenuItem exitItem = new MenuItem("Exit");
//        CheckboxMenuItem show_recent = new CheckboxMenuItem("Show Notification");
//        CheckboxMenuItem hide_recent = new CheckboxMenuItem("Hide Notification");
//
//
//        show_recent.addItemListener(new ItemListener() {
//
//            @Override
//            public void itemStateChanged(ItemEvent e) {
//
//
//            }
//        });
//        hide_recent.addItemListener(new ItemListener() {
//
//            @Override
//            public void itemStateChanged(ItemEvent e) {
//            }
//        });
//        popup.add(show_recent);
//        popup.add(hide_recent);
//        popup.add(exitItem);
//
//
//        trayIcon.setPopupMenu(popup);
//        try {
//            tray.add(trayIcon);
//        } catch (AWTException e) {
//            System.out.println("TrayIcon could not be added.");
//            return;
//        }
//        trayIcon.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                new Global().openRootDirectory();
//            }
//        });
//        trayIcon.addMouseListener(new MouseListener() {
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
////				if(e.getClickCount()==1){
////					if(SwingUtilities.isRightMouseButton(e)){
////						if(Global.operationLog.size()>0){
////							if(Global.syncRecentTask.visible()){
////								Global.syncRecentTask.close();
////								log("recent closed");
////								return;
////							}
////							if(!Global.syncRecentTask.visible()){
////								Global.syncRecentTask.setVisible(true);
////								log("recent opened");
////								return;
////							}
////						}
////
////					}
////				}
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//            }
//
//            @Override
//            public void mouseClicked(MouseEvent e) {
//            }
//        });
//        exitItem.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                tray.remove(trayIcon);
//                System.exit(0);
//            }
//        });
//
//        trayIcon.setToolTip(SystemTaskMassage);
//    }

    /**
     * get image form system
     *
     * @param path
     * @return {@link Image}
     */
    public Image createImage(String path) {
        URL iconURL = getClass().getResource(path);
        ImageIcon icon = new ImageIcon(iconURL);
        return icon.getImage();
    }

    /**
     * create image icon
     *
     * @param path
     * @return
     */
    public ImageIcon createImageIcon(String path) {
        BufferedImage bufferedImage;
        ImageIcon imageIcon = null;
        try {
            bufferedImage = ImageIO.read(getClass().getResource(path));
            imageIcon = new ImageIcon(bufferedImage);
        } catch (ImagingOpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (imageIcon != null) ? imageIcon : null;
    }


    /**
     * check if string length is grater
     *
     * @param string
     * @return
     */
    public String checkNamelength(String string) {
        if (string.length() > 10) {
            string = string.substring(0, 10) + "...";
        }
        return string;
    }


    /**
     * check if string is null
     *
     * @param value string to check
     * @return null or value
     */
    public String checkNull(String value) {
        return value != null ? value : " ";
    }

    /**
     * save error report
     *
     * @param tag     text to attach
     * @param strings array of error
     * @param error   actual error
     */
    public void saveReport(String tag, StackTraceElement[] strings, String error) {
        checkDir();
        File dir = new File(ROOT + "/" + tag + "__" + getTodayDate() + "__" + getCurrentTime() + ".log");
        StringBuilder builder = new StringBuilder();
        String report;
        if (root.isDirectory()) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dir)));
                builder.append("TAG : " + tag);
                builder.append("\n");
                builder.append("---------------Error--------------");
                builder.append("\n");
                builder.append("\n");
                builder.append(error);
                builder.append("\n");
                builder.append("\n");
                builder.append("---------------Detail-------------");
                builder.append("\n");
                for (StackTraceElement element : strings) {
                    builder.append(element);
                    builder.append("\n");
                }
                report = builder.toString();
                bufferedWriter.write(report);
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * save run time exception to system
     *
     * @param strings error
     */
    public void saveRunCaught(String strings) {
        checkDir();
        File dir = new File(ROOT + "/" + getTodayDate() + "__" + getCurrentTime() + ".txt");
        if (root.isDirectory()) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dir)));
                bufferedWriter.write(strings);
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (IOException io) {
                io.printStackTrace();
            }
        }
    }

    /**
     * get current date
     *
     * @return date string
     */
    public String getTodayDate() {
        final Calendar c = Calendar.getInstance();
        int todayDate = (c.get(Calendar.YEAR) * 10000) +
                ((c.get(Calendar.MONTH) + 1) * 100) +
                (c.get(Calendar.DAY_OF_MONTH));
        log("DATE:", String.valueOf(todayDate));
        return (String.valueOf(todayDate));
    }

    /**
     * get current time
     *
     * @return time string
     */
    public String getCurrentTime() {
        final Calendar c = Calendar.getInstance();
        int currentTime = (c.get(Calendar.HOUR_OF_DAY) * 10000) +
                (c.get(Calendar.MINUTE) * 100) +
                (c.get(Calendar.SECOND));
        log("TIME:", String.valueOf(currentTime));
        return (String.valueOf(currentTime));
    }

    /**
     * check if directory exist or not
     */
    public void checkDir() {
        if (!system_root.exists()) {
            system_root.mkdir();
        }
        if (!root.exists()) {
            root.mkdir();
        }
    }


    /**
     * get date formatted
     *
     * @return date string
     */
    public static String getDate() {
        return day + "/" + month + "/" + yr;
    }

    /**
     * log to console
     *
     * @param TAG activity name
     * @param msg message to print
     */
    public static void log(String TAG, String msg) {
        System.out.println(TAG + ":" + msg);
    }
}

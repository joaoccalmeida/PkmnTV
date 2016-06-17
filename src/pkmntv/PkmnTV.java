// Licensed under GPLv2 or any later version
// Refer to the license.txt file included.

package pkmntv;

import javafx.application.Application;
import javafx.stage.Stage;
import pkmntv.ui.MainWindow;

/**
 *
 * @author João
 */
public class PkmnTV extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        new MainWindow().setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

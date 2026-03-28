// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import javax.swing.SwingUtilities;

public class StudentInfoApp {
   public StudentInfoApp() {
   }

   public static void main(String[] var0) {
      SwingUtilities.invokeLater(() -> {
         StudentView var0 = new StudentView();
         StudentRepository var1 = new StudentRepository();
         new StudentController(var0, var1);
         var0.setVisible(true);
      });
   }
}

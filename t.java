import javax.swing.*;

public class t {
  public static void main(String[] args) {
    int n = Integer.parseInt(JOptionPane.showInputDialog("orden de n "));
    int c = Integer.parseInt(JOptionPane.showInputDialog("orden de c "));
    int m[][] = new int[n][c];
    String res = "";
    // String x="";
    for (int i = 0; i < m.length; i++) {
      res += "\n";
      for (int j = 0; j < m[i].length; j++) {
        m[i][j] = (int) (Math.random() * 40 + 1);
        res = res + m[i][j] + " ";
      }

      JTextArea jt = new JTextArea(10, 10);
      // JScrollPane sp = new JScrollPane(jt);
      // JScrollPane s = new JScrollPane(jt);
      jt.setText(res);

      JOptionPane.showMessageDialog(null, res);

    }
  }
}
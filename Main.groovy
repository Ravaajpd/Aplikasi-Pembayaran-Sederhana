import javax.swing.*

SwingUtilities.invokeLater({
  try {
    def window = new PembayaranAppGUI()
    window.frame.setVisible(true)
  } catch (Exception e) {
    e.printStackTrace()
  }
} as Runnable)

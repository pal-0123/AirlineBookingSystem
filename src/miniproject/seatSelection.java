/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.util.*;
import static miniproject.MiniProject.*;
import static miniproject.ex.*;
import static miniproject.login.*;

/**
 *
 * @author pal_0123
 */
class myj extends JPanel {

    public void paint(Graphics g) {
        System.out.println(seatchoice);
        super.paint(g);
        System.out.println("dv");

        int i;

        int j;
        Graphics2D g1 = (Graphics2D) g;
        g1.setColor(Color.red);
//        g1.fillOval(10,10,5,5);

        int sizex = 453;
        int sizey = 483;
        g1.setStroke(new BasicStroke(3));

        for (i = 0; i < m + 1; i++) {
            g1.setColor(Color.BLACK);
            g1.drawLine((sizex * i) / (m), 0, (sizex * i) / (m), sizey);

        }
        g1.drawLine(0, 0, sizex, 0);
        g1.drawLine(0, sizey, sizex, sizey);

        for (i = 0; i < m; i++) {
            if (matrix[0].charAt(i) != '3') {

                for (j = 1; j <= n; j++) {
                    g1.drawLine((sizex * i) / (m), sizey * j / n, (sizex * (i + 1)) / (m), sizey * j / n);

                }
            }
        }
        for (i = 0; i < book.size(); i++) {
            int r1 = sizex / m;
            int r2 = sizey / n;
            g1.setColor(Color.YELLOW);

            g1.fillOval(book.get(i).x * r1 + 2*r1 / 10, book.get(i).y * r2 + 2*r2 / 10, r1 * 6 / 10, r2 * 6 / 10);
        }
        for (i = 0; i < selec.size(); i++) {
            int r1 = sizex / m;
            int r2 = sizey / n;
            g1.setColor(Color.green);

            g1.fillOval(selec.get(i).x * r1 + 2*r1 / 10, selec.get(i).y * r2 + 2*r2 / 10, r1 * 6 / 10, r2 * 6 / 10);
        }

    }
}

public class seatSelection extends javax.swing.JFrame {

    /**
     * Creates new form seatSelection
     */
    public seatSelection() {
        try{
            selec.clear();
            
            book.clear();
        }
        catch(Exception e){
            ;
        }
        initComponents();
        for (int i = 0; i < n; i++) {
            matrix[i] = tt.seats[i];

            for (int j = 0; j < m; j++) {
                if ((matrix[i].charAt(j) == '1' && seatchoice == 2) || (matrix[i].charAt(j) == '2' && seatchoice == 1)) {
                    ;
                } else if (matrix[i].charAt(j) != '3' && matrix[i].charAt(j) != '4') {
                    book.add(new Point(j, i));
                }
            }

        }

        repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myj jPanel1;
        jPanel1 = new myj();
        jButton1 = new javax.swing.JButton();

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 483, Short.MAX_VALUE)
        );

        jButton1.setText("Proceed");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        System.out.println(evt.getX() + " " + evt.getY());

        int x1 = evt.getX();
        int y1 = evt.getY();
        int n1, n2;
        n1 = 453 / m;
        n2 = 483 / n;
        int index2 = -1;
        int index1 = -1;
        for (int i = 0; i < n; i++) {
            if (y1 >= i * n2 && y1 <= (i + 1) * n2) {
                index2 = i;
            }
        }
        for (int i = 0; i < m; i++) {
            if (x1 >= i * n1 && x1 <= (i + 1) * n1) {
                index1 = i;
            }
        }
        
        if(index1!=-1&&index2!=-1){
            for(int j=0;j<selec.size();j++){
                if(selec.get(j).x==index1 && selec.get(j).y==index2){
                    selec.remove(j);
                    repaint();
                    return ;
                }
            }
            for(int j=0;j<book.size();j++){
                if(book.get(j).x==index1 && book.get(j).y==index2){
//                    selec.remove(j);
                    repaint();
                    return ;
                }
            }
            if(matrix[index2].charAt(index1)=='3'){
                repaint();
                return ;
            }
            if(selec.size()!=allpassenger.size()){
                selec.add(new Point(index1,index2));
            }
            
        }
        repaint();

        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(selec.size()==allpassenger.size()){
            new makepayment().setVisible(true);
            setVisible(false);
            for(int i=0;i<selec.size();i++){
                char[] c=resultsDirect.get(flightselect).seats[selec.get(i).y].toCharArray();
                c[selec.get(i).x]='0';
                int use=-1;
                for(int j=0;j<allflight.size();j++){
                    if(resultsDirect.get(flightselect).id==allflight.get(j).id){
                        use=j;
                    }
                }
                allflight.get(use).seats[selec.get(i).y]=String.valueOf(c);
//                        setCharAt(,'0');
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(seatSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(seatSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(seatSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(seatSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new seatSelection().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

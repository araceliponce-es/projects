
/*
 * Copyright (C) 2025 Antonio de Andrés Lema
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package view;

import model.Game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;

/**
 * Clase que implementa a ventá principal do xogo do Tetris
 *
 * @author Profe de Programación
 */
public class MainWindow extends javax.swing.JFrame {

    // Referenza ao obxecto da partida actual
    private Game game = null;
    private Timer timer;
    private int level;
    private int levelcap = 2;

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        pnlGame.setLayout(null);
        //quita el foco a los botones para que Space no los enfoque
        btnNewGame.setFocusable(false);
        btnLeft.setFocusable(false);
        btnRight.setFocusable(false);
        btnDown.setFocusable(false);
        btnRotate.setFocusable(false);
        tglbtnPause.setFocusable(false);
        configKeys(); //usa teclado 
    }

    /**
     * Pinta un cadrado no panel do xogo
     *
     * @param lblSquare Etiqueta co cadrado que se quere pintar no panel
     */
    public void drawSquare(JLabel lblSquare) {
        pnlGame.add(lblSquare);
        pnlGame.repaint();
    }

    /**
     * Borra un cadrado do panel do xogo
     *
     * @param lblSquare Etiqueta co cadrado que se quere borrar do panel
     */
    public void deleteSquare(JLabel lblSquare) {
        pnlGame.remove(lblSquare);
        pnlGame.repaint();
    }
    public void showLevel(int numberOfLines ){
        level = ((numberOfLines/3)+1);
        lblNumberOfLevel.setText(Integer.toString(level));
        //Si el nivel alcanza el level cap entonces aumenta el level cap y aumenta
        // la velocidad
        if(levelcap==level){
            timer.setDelay(timer.getDelay()/2);
            levelcap++;
        }
    }
    /**
     * Actualiza na ventá o número de liñas que van feitas no xogo
     *
     * @param numberOfLines Número de liñas feitas no xogo
     */
    public void showNumberOfLines(int numberOfLines) {
        lblNumberOfLines.setText(String.valueOf(numberOfLines));
    }

    /**
     * Mostra unha mensaxe informando ao usuario do final do xogo
     */
    public void showGameOver() {
        game = null;
        JOptionPane.showMessageDialog(this, "Fin do xogo");
    }

    /**
     * Inicia un novo xogo
     */
    private void startGame() {

        // Limpamos todo o que puidese haber pintado no panel do xogo
        pnlGame.removeAll();
        // Creamos un novo obxecto xogo
        game = new Game(this);
        // Desactivamos o botón de pausa
        tglbtnPause.setSelected(false);
        // Establecemos o número de liñas que se mostran na ventá a cero
        lblNumberOfLines.setText("0");
        //Cuando creas un nuevo juego para el timer anterior para no multiplicarse
        if (timer != null) {
            timer.stop();
        }
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnDownActionPerformed(e);
            }
        });
        timer.start();
    }

    private void configKeys() {

        JComponent root = this.getRootPane();
        InputMap im = root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = root.getActionMap();

        // ENTER → Nueva partida
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "newGame");
        am.put("newGame", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnNewGame.doClick();
            }
        });

        // Espacio = Pausa
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "pause");
        am.put("pause", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tglbtnPause.doClick();
            }
        });
        // ← Izquierda
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "left");
        am.put("left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLeft.doClick();
            }
        });

        // → Derecha
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "right");
        am.put("right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRight.doClick();
            }
        });

        // ↓ Abajo
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "down");
        am.put("down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnDown.doClick();
            }
        });

        // ↑ Rotar
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "rotate");
        am.put("rotate", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRotate.doClick();
            }
        });

        // Usar ADSW Y adsw
        im.put(KeyStroke.getKeyStroke('A'), "left");
        im.put(KeyStroke.getKeyStroke('a'), "left");
        im.put(KeyStroke.getKeyStroke('D'), "right");
        im.put(KeyStroke.getKeyStroke('d'), "right");
        im.put(KeyStroke.getKeyStroke('S'), "down");
        im.put(KeyStroke.getKeyStroke('s'), "down");
        im.put(KeyStroke.getKeyStroke('W'), "rotate");
        im.put(KeyStroke.getKeyStroke('w'), "rotate");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        btnNewGame = new javax.swing.JButton();
        pnlGame = new javax.swing.JPanel();
        btnRotate = new javax.swing.JButton();
        btnRight = new javax.swing.JButton();
        btnLeft = new javax.swing.JButton();
        btnDown = new javax.swing.JButton();
        tglbtnPause = new javax.swing.JToggleButton();
        lblLines = new javax.swing.JLabel();
        lblNumberOfLines = new javax.swing.JLabel();
        JUsuarioAuto = new javax.swing.JLabel();
        JUsuarioText = new javax.swing.JLabel();
        lblNivel = new javax.swing.JLabel();
        lblNumberOfLevel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Teistris");
        setLocation(new java.awt.Point(150, 300));
        setResizable(false);

        btnNewGame.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        btnNewGame.setText("Nova partida");
        btnNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewGameActionPerformed(evt);
            }
        });

        pnlGame.setBackground(java.awt.Color.white);
        pnlGame.setPreferredSize(new java.awt.Dimension(320, 420));

        javax.swing.GroupLayout pnlGameLayout = new javax.swing.GroupLayout(pnlGame);
        pnlGame.setLayout(pnlGameLayout);
        pnlGameLayout.setHorizontalGroup(
            pnlGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        pnlGameLayout.setVerticalGroup(
            pnlGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        btnRotate.setBackground(new java.awt.Color(51, 51, 255));
        btnRotate.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        btnRotate.setText("Rotar");
        btnRotate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRotateActionPerformed(evt);
            }
        });

        btnRight.setBackground(new java.awt.Color(255, 255, 102));
        btnRight.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        btnRight.setText("Dereita");
        btnRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRightActionPerformed(evt);
            }
        });

        btnLeft.setBackground(new java.awt.Color(255, 51, 51));
        btnLeft.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        btnLeft.setText("Esquerda");
        btnLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeftActionPerformed(evt);
            }
        });

        btnDown.setBackground(new java.awt.Color(102, 255, 102));
        btnDown.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        btnDown.setText("Abaixo");
        btnDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownActionPerformed(evt);
            }
        });

        tglbtnPause.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        tglbtnPause.setText("Pausa");
        tglbtnPause.setToolTipText("");
        tglbtnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglbtnPauseActionPerformed(evt);
            }
        });

        lblLines.setFont(new java.awt.Font("Courier 10 Pitch", 1, 16)); // NOI18N
        lblLines.setText("Puntuacion :");

        lblNumberOfLines.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        lblNumberOfLines.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNumberOfLines.setText("0");

        JUsuarioAuto.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        JUsuarioAuto.setText(System.getProperty("user.name")
        );

        JUsuarioText.setFont(new java.awt.Font("Courier 10 Pitch", 1, 16)); // NOI18N
        JUsuarioText.setText("Usuario : ");

        lblNivel.setFont(new java.awt.Font("Courier 10 Pitch", 1, 16)); // NOI18N
        lblNivel.setText("Nivel:");

        lblNumberOfLevel.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        lblNumberOfLevel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNumberOfLevel.setText("1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JUsuarioText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JUsuarioAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblNumberOfLines, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLines, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNivel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNumberOfLevel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tglbtnPause, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addComponent(pnlGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRight, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnDown, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRotate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(btnRotate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLeft)
                    .addComponent(btnRight))
                .addGap(18, 18, 18)
                .addComponent(btnDown)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JUsuarioAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JUsuarioText))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblLines)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNumberOfLines, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNivel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNumberOfLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNewGame)
                        .addGap(18, 18, 18)
                        .addComponent(tglbtnPause)
                        .addGap(135, 135, 135))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 51, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewGameActionPerformed
        // Ao picar no botón de "Nova partida", invocamos ao método privado 
        // que inicia un novo xogo
        startGame();


    }//GEN-LAST:event_btnNewGameActionPerformed

    private void tglbtnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglbtnPauseActionPerformed
        // Ao picar no botón de "Pausa", chamamos ao obxecto xogo para 
        // establecer o atributo de pausa no estado do botón
        if (game != null) {
            timer.stop();
            game.setPaused(tglbtnPause.isSelected());
            //Comprueba si el boton de pausa no esta pausado y deja correr el timer
            if(!tglbtnPause.isSelected()){
                timer.start();
            }
        }
    }//GEN-LAST:event_tglbtnPauseActionPerformed

    private void btnRotateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRotateActionPerformed
        // Ao picar no botón de "Rotar", chamamos ao obxecto xogo para que 
        // rote a peza actual
        if (game != null) {
            game.rotatePiece();
        }
    }//GEN-LAST:event_btnRotateActionPerformed

    private void btnLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeftActionPerformed
        // Ao picar no botón de "Esquerda", chamamos ao obxecto xogo para que
        // se mova a peza actual á esquerda
        if (game != null) {
            game.movePieceLeft();
        }
    }//GEN-LAST:event_btnLeftActionPerformed

    private void btnRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRightActionPerformed
        // Ao picar no botón de "Dereita", chamamos ao obxecto xogo para que
        // se mova a peza actual á dereita
        if (game != null) {
            game.movePieceRight();
        }
    }//GEN-LAST:event_btnRightActionPerformed

    private void btnDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownActionPerformed
        // Ao picar no botón de "Abaixo", chamamos ao obxecto xogo para que
        // se mova a peza actual cara abaixo
        if (game != null) {
            game.movePieceDown();
        }
    }//GEN-LAST:event_btnDownActionPerformed

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JUsuarioAuto;
    private javax.swing.JLabel JUsuarioText;
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnLeft;
    private javax.swing.JButton btnNewGame;
    private javax.swing.JButton btnRight;
    private javax.swing.JButton btnRotate;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lblLines;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblNumberOfLevel;
    private javax.swing.JLabel lblNumberOfLines;
    private javax.swing.JPanel pnlGame;
    private javax.swing.JToggleButton tglbtnPause;
    // End of variables declaration//GEN-END:variables
}

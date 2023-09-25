/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;


import accesoADatos.MateriaData;
import entidades.Alumno;
import entidades.Materia;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;


public class PanelMateria extends javax.swing.JInternalFrame {

   
    public PanelMateria() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTCodigo = new javax.swing.JTextField();
        jBbuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTnombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTaño = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Estado = new javax.swing.JRadioButton();
        jBnuevo = new javax.swing.JButton();
        jBeliminar = new javax.swing.JButton();
        jBmodificar = new javax.swing.JButton();
        jBsalir = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        jLabel5.setText("jLabel5");

        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("MATERIA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Codigo: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));
        getContentPane().add(jTCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 160, -1));

        jBbuscar.setText("buscar");
        jBbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jBbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 80, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Nombre: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));
        getContentPane().add(jTnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 290, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Año: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));
        getContentPane().add(jTaño, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 100, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Estado: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));
        getContentPane().add(Estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, -1, -1));

        jBnuevo.setText("nuevo");
        jBnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBnuevoActionPerformed(evt);
            }
        });
        getContentPane().add(jBnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, -1, -1));

        jBeliminar.setText("eliminar");
        jBeliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBeliminarActionPerformed(evt);
            }
        });
        getContentPane().add(jBeliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, -1, -1));

        jBmodificar.setText("modificar");
        jBmodificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBmodificarMouseClicked(evt);
            }
        });
        getContentPane().add(jBmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, -1, -1));

        jBsalir.setText("Salir");
        jBsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalirActionPerformed(evt);
            }
        });
        getContentPane().add(jBsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, 70, -1));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalirActionPerformed
      
        this.dispose();
    }//GEN-LAST:event_jBsalirActionPerformed

    private void jBnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBnuevoActionPerformed
      if (jTnombre.getText().isEmpty() || jTCodigo.getText().isEmpty()|| jTaño.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe completar todos los campos");
        } else {
            try {
                int dni = Integer.parseInt(jTCodigo.getText());
               
                String nombre = jTnombre.getText();
                boolean estado = Estado.isSelected();
                int fecha = Integer.parseInt(jTaño.getText());
   
                if (verificarNombreApellido(nombre) == false) {

                    Materia materia = new Materia(nombre, fecha, estado);
                    MateriaData.cargaMateia(materia);
                    JOptionPane.showMessageDialog(this, "materia cargado correctamente");

                    jTnombre.setText("");
                    jTCodigo.setText("");
                    jTaño.setText("");
                    Estado.setSelected(false);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingrese correctamente su codigo");
                jTCodigo.setText("");
            }

        }
    }//GEN-LAST:event_jBnuevoActionPerformed

    private void jBbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBbuscarActionPerformed
       
         try {
            int codigo = Integer.parseInt(jTCodigo.getText());
            Materia materia = MateriaData.buscarMateria(codigo);

            // Hacer algo con el objeto Alumno encontrado (por ejemplo, mostrarlo en una ventana)
            if (materia != null) {
                jTaño.setText(materia.getAñomateria()+"");
                jTnombre.setText(materia.getNombre());
                Estado.setSelected(materia.isActivo());

                String mensaje = "Nombre: " + materia.getNombre() + "\n"
                        + "Año: " + materia.getAñomateria()+ "\n"
                        + "Estado: " + (materia.isActivo() ? "Activo" : "Inactivo");
                       
                JOptionPane.showMessageDialog(null, mensaje, "Información del materia", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún materia con el codigo proporcionado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un codigo valido", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jBbuscarActionPerformed

    private void jBeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBeliminarActionPerformed
       
        try {
            int codigo = Integer.parseInt(jTCodigo.getText());
            Materia materia = MateriaData.buscarMateria(codigo);
            int idmateria = materia.getIdMateria();
            if (materia != null) {
                materia.setActivo(false);
                Estado.setSelected(false); 
                
                
                MateriaData.eliminarMateria(idmateria);//arreglar codigo 
                
                
                JOptionPane.showMessageDialog(
                        null,
                        "la materia:" + materia.getNombre() + " ha sido marcado como inactivo",
                        "Desactivacion exitosa",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "No se encontro ninguna alumno",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Ingrese un numero de dni valido",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
 
    }//GEN-LAST:event_jBeliminarActionPerformed

    private void jBmodificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBmodificarMouseClicked
        int codigo = 0 ;

        try {
            codigo = Integer.parseInt(jTCodigo.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese su codigo correctamente", "Error", JOptionPane.ERROR_MESSAGE);
            jTCodigo.setText("");
            return;
        }

        Materia materia = MateriaData.buscarMateria(codigo);;
        int idmateria= materia.getIdMateria();
        if ( jTnombre.getText().isEmpty() || jTCodigo.getText().isEmpty() || jTaño.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe completar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                String nombre = jTnombre.getText();
                int ano = Integer.parseInt(jTaño.getText());

                if (!verificarNombreApellido(nombre)) {
                    materia.setNombre(nombre);
                    materia.setAñomateria(ano);
                    materia.setActivo(Estado.isSelected());

                    MateriaData.modificarMateria(materia);

                    JOptionPane.showMessageDialog(this, "la materia ha sido modificado");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "la materia o ha sido modificado");
            }
        }
    }//GEN-LAST:event_jBmodificarMouseClicked
private boolean verificarNombreApellido(String nombre) {

        int largoNombre = nombre.length();
        boolean bandera1 = false;
      
        for (int i = 0; i < largoNombre; i++) {
            bandera1 = false;
            if (Character.isDigit(nombre.charAt(i))) {
                JOptionPane.showMessageDialog(this, "Su nombre contiene números");
                jTnombre.setText("");
                bandera1 = true;
                break;
            }

        }

        
        return bandera1;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Estado;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jBbuscar;
    private javax.swing.JButton jBeliminar;
    private javax.swing.JButton jBmodificar;
    private javax.swing.JButton jBnuevo;
    private javax.swing.JButton jBsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTCodigo;
    private javax.swing.JTextField jTaño;
    private javax.swing.JTextField jTnombre;
    // End of variables declaration//GEN-END:variables

   
}

package Vistas;

import accesoADatos.AlumnoData;
import accesoADatos.InscripcionData;
import accesoADatos.MateriaData;
import entidades.Alumno;
import entidades.Materia;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PanelManejoInscripciones extends javax.swing.JInternalFrame {

    DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int fila, int columna) {

            return false;
        }
    };
    Alumno alumno = null;

    public PanelManejoInscripciones() {
        initComponents();
        armarCabecera();
        cargarCombo();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLFormInscripcion = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCBAlumno = new javax.swing.JComboBox<>();
        jLFormInscripcion1 = new javax.swing.JLabel();
        jRMateriaIns = new javax.swing.JRadioButton();
        jRMateriaNoIns = new javax.swing.JRadioButton();
        jbtnInscribir = new javax.swing.JButton();
        jbtnAnularInscripcion = new javax.swing.JButton();
        jbtnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        fondo = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(600, 500));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLFormInscripcion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLFormInscripcion.setForeground(new java.awt.Color(0, 0, 0));
        jLFormInscripcion.setText("Formulario de Inscripción");
        jPanel1.add(jLFormInscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Seleccione un alumno");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        jCBAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBAlumnoActionPerformed(evt);
            }
        });
        jPanel1.add(jCBAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 350, -1));

        jLFormInscripcion1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLFormInscripcion1.setForeground(new java.awt.Color(0, 0, 0));
        jLFormInscripcion1.setText("Listado de materias");
        jPanel1.add(jLFormInscripcion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 118, -1, -1));

        jRMateriaIns.setText("Materias Inscriptas");
        jRMateriaIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRMateriaInsActionPerformed(evt);
            }
        });
        jPanel1.add(jRMateriaIns, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        jRMateriaNoIns.setText("Materias no inscriptas");
        jRMateriaNoIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRMateriaNoInsActionPerformed(evt);
            }
        });
        jPanel1.add(jRMateriaNoIns, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, -1, -1));

        jbtnInscribir.setText("Inscribir");
        jbtnInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnInscribirActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnInscribir, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, -1, -1));

        jbtnAnularInscripcion.setText("Anular Inscripción");
        jbtnAnularInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAnularInscripcionActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnAnularInscripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, -1, -1));

        jbtnSalir.setText("Salir");
        jbtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, -1, -1));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 195, 480, 146));
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 6, 620, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnSalirActionPerformed

    private void jRMateriaInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRMateriaInsActionPerformed
        if (alumno == null) {
            JOptionPane.showMessageDialog(this, "debe seleccionar un alumno activo");
             jRMateriaIns.setSelected(false);
        } else {
            vaciarTabla();
            jbtnInscribir.setEnabled(false);
            jbtnAnularInscripcion.setEnabled(true);
            armarTabla(InscripcionData.buscarinscripciones(alumno));
            jRMateriaNoIns.setSelected(false);
        }
    }//GEN-LAST:event_jRMateriaInsActionPerformed

    private void jCBAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBAlumnoActionPerformed
        jRMateriaNoIns.setSelected(false);
        jRMateriaIns.setSelected(false);
        alumno = (Alumno) jCBAlumno.getSelectedItem();
        vaciarTabla();
        if (alumno.isActivo()==false) {
            JOptionPane.showMessageDialog(this, "El alumno se encuentra inactivo");
            alumno=null;
        }
    }//GEN-LAST:event_jCBAlumnoActionPerformed

    private void jRMateriaNoInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRMateriaNoInsActionPerformed
        if (alumno == null) {
            JOptionPane.showMessageDialog(this, "debe seleccionar un alumno activo");
             jRMateriaNoIns.setSelected(false);
        } else {
            vaciarTabla();
            jbtnAnularInscripcion.setEnabled(false);
            jbtnInscribir.setEnabled(true);
            jRMateriaIns.setSelected(false);
            ArrayList<Materia> materias = new ArrayList<>();
            materias = InscripcionData.buscarinscripciones(alumno);
            if (materias.isEmpty()) {
                armarTabla(MateriaData.listaTodasMaterias());
            } else {

                armarTabla(InscripcionData.listadoMateriasNoInscriptas(materias));
            }
        }
    }//GEN-LAST:event_jRMateriaNoInsActionPerformed

    private void jbtnInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnInscribirActionPerformed
        int filaSeleccionada = jTable.getSelectedRow();
        if (filaSeleccionada != -1) {
            int materiaId = (int) (jTable.getValueAt(filaSeleccionada, 0));
            String materia = (String) (jTable.getValueAt(filaSeleccionada, 1));

            InscripcionData.inscribirseMateria(materiaId, alumno);
            JOptionPane.showMessageDialog(this, "Se inscribio a la materia: " + materia + " \n exitosamente");
            actualizarTabla();
        } else {
            if (alumno == null) {
                JOptionPane.showMessageDialog(this, "debe seleccionar un alumno activo");
            } else {
                JOptionPane.showMessageDialog(this, "debe Seleccionar una materia");
            }
        }
        // TODO add your handling code here:}
    }//GEN-LAST:event_jbtnInscribirActionPerformed

    private void jbtnAnularInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAnularInscripcionActionPerformed

        int filaSeleccionada = jTable.getSelectedRow();
        if (filaSeleccionada != -1) {
            int materiaId = (int) (jTable.getValueAt(filaSeleccionada, 0));
            String materia = (String) (jTable.getValueAt(filaSeleccionada, 1));
            InscripcionData.borrarIncripcion(materiaId, alumno);
            JOptionPane.showMessageDialog(this, "se borro la inscripcion a la materia: " + materia);
            actualizarTabla2();
        } else {
            if (alumno == null) {
                JOptionPane.showMessageDialog(this, "debe seleccionar un alumno activo");
            } else {
                JOptionPane.showMessageDialog(this, "debe Seleccionar una materia");
            }
        } // TODO add your handling code here:
    }//GEN-LAST:event_jbtnAnularInscripcionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondo;
    private javax.swing.JComboBox<Alumno> jCBAlumno;
    private javax.swing.JLabel jLFormInscripcion;
    private javax.swing.JLabel jLFormInscripcion1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRMateriaIns;
    private javax.swing.JRadioButton jRMateriaNoIns;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton jbtnAnularInscripcion;
    private javax.swing.JButton jbtnInscribir;
    private javax.swing.JButton jbtnSalir;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {
        modelo.addColumn("ID Materia");
        modelo.addColumn("Nombre");
        modelo.addColumn("Año");
        jTable.setModel(modelo);

    }

    private void armarTabla(ArrayList<Materia> materias) {
        //tenemos el alumno

        for (Materia materia : materias) {
            modelo.addRow(new Object[]{materia.getIdMateria(), materia.getNombre(), materia.getAñomateria()});
        }

    }

    private void cargarCombo() {
        ArrayList<Alumno> alu = AlumnoData.listarAlumno();
        jCBAlumno.addItem(null);
        for (Alumno alumno : alu) {
            jCBAlumno.addItem(alumno);
        }

    }

    private void vaciarTabla() {
        modelo.setRowCount(0);
    }

    private void actualizarTabla() {
        vaciarTabla();

        ArrayList<Materia> materias = new ArrayList<>();
        materias = InscripcionData.buscarinscripciones(alumno);
        if (materias.isEmpty()) {
            armarTabla(MateriaData.listaTodasMaterias());
        } else {

            armarTabla(InscripcionData.listadoMateriasNoInscriptas(materias));
        }

    }

    private void actualizarTabla2() {
        vaciarTabla();
        armarTabla(InscripcionData.buscarinscripciones(alumno));
    }
}

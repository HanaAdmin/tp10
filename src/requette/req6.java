package requette;



import java.awt.Container;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;





import connection.connection;
public class req6 extends javax.swing.JFrame{/*
	 * To change this license header, choose License Headers in Project Properties.
	 * To change this template file, choose Tools | Templates
	 * and open the template in the editor.
	 */
	
	//private JButton bfer;

	//public class FenetreListeProduit extends javax.swing.JFrame {
	Statement stListe;
	connection maconnexion = new connection();
	 
	    /**
	     * Creates new form FenetreListeProduitl
	     */
	    public req6() {
	        initComponents();
	        this.setLocation(500, 200);
	      	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	        DefaultTableModel model=new DefaultTableModel();
	       // model.addColumn("Numero_eleve");
	        model.addColumn("Nom");
	        model.addColumn("Nom_cours");
	        //model.addColumn("Heure");
	       // model.addColumn("Salaire");
	        model.addColumn("Tel");
	        TABLEPRO.setModel(model);
	  	   String requeteListe = "select COURS.num_crs,COURS.nom_crs from COURS ,ELEVE,resultat \n where\n  ELEVE.num_elv = resultat.num_elv \n and \n resultat.num_crs = cours.num_crs \n and \n COURS.ANN='2014' \n and \n ELEVE.PREN ='yacouba'";;
	        try{
	            stListe=maconnexion.etablirconnection().createStatement();
	            ResultSet resultat =stListe.executeQuery(requeteListe);
	            while(resultat.next()){
	                model.addRow(new Object []{resultat.getString("cours.num_crs"),resultat.getString("cours.nom_crs")});
	            }
	        }catch(SQLException ex){
	           JOptionPane.showMessageDialog(this, "Aucun Element trouv� Merci");
	        }
	      
	    }

	    /**
	     * This method is called from within the constructor to initialize the form.
	     * WARNING: Do NOT modify this code. The content of this method is always
	     * regenerated by the Form Editor.
	     */
	    @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	    private void initComponents() {

	        jLabel1 = new javax.swing.JLabel();
	        TABLE = new javax.swing.JScrollPane();
	        TABLEPRO = new javax.swing.JTable();
	       

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

	        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
	        jLabel1.setText("LISTE DES RESULTATS");
	       

	        TABLEPRO.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	                {null, null, null, null,null},
	                {null, null, null, null,null},
	                {null, null, null, null,null},
	                {null, null, null, null,null}
	            },
	            new String [] {
	                "Title 1", "Title 2", "Title 3"
	            }
	        ));
	        TABLE.setViewportView(TABLEPRO);

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
	                    .addGroup(layout.createSequentialGroup()
	                        .addGap(22, 22, 22)
	                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addComponent(TABLE, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap(15, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(TABLE, javax.swing.GroupLayout.PREFERRED_SIZE,155, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	              
	        );
	       
	        pack();
	      
	    }// </editor-fold>                        
	 
	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String args[]) {
	       
	        try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(req6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(req6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(req6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(req6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        //</editor-fold>

	        // Create and display the form 
	         
	       java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	               new req6().setVisible(true);
	            }
	        }); 
	    }
	    
	    // Variables declaration - do not modify                     
	    private javax.swing.JScrollPane TABLE;
	    private javax.swing.JTable TABLEPRO;
	    private javax.swing.JLabel jLabel1;
	   
	    // End of variables declaration                   
	}



package frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import connection.connection;

public class fen_Activites_Pratiques extends JFrame implements ActionListener{
	
	private JTextField txttl;
	private JLabel lbnump,lbnumc,lbtl;
	private JButton bten,ann;
	private JComboBox cmboniv=new JComboBox();
	private JComboBox cmbonumelv=new JComboBox();
	Statement st;
	private String req1 = " select DISTINCT Niveau from activites";
	private String req2 = " select DISTINCT num_elv from  eleve";
	
	
	
	connection k=new connection();
	
	public fen_Activites_Pratiques()
	{  this.setLocation(500, 200);
  	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	   initCombo();
	  this.setTitle("Enregistrement_Activ_pratiq_eleve_");
	  this.setSize(400,300);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
     JPanel p=new JPanel();  p.setBackground(Color.white);
     p.setLayout(null);
     //JLabel lbpt=new JLabel("point :");
     JLabel lbnump=new JLabel("niveau:");
     JLabel lbnumc=new JLabel("Numero_eleve");
     JLabel lbtl=new JLabel("Nombre fois");
     
     
       txttl=new JTextField();
  
    
     
     
     bten=new JButton("Sauver");
     ann=new JButton("Terminer");
     
     //bten.addActionListener(this);
    // ann.addActionListener(this);
     
     
     //boutton
     Font fe=new Font("Serif",0,15);
     
     /*supp=new JButton("Supprimer");
     
     modif=new JButton("Modifier");
     
     rech=new JButton("Rechercher");
     
     fer=new JButton("Terminez");
     
     
     
     supp.addActionListener(this);
     modif.addActionListener(this);
     rech.addActionListener(this);
     */
    // fer.addActionListener(this);
     
     
     
     //ajouts dans le panel
    lbnump.setBounds(30,30,120,25); p.add(lbnump);
    cmboniv.setBounds(200,30,120,25); p.add(cmboniv);
    
    
     cmboniv.setForeground(Color.CYAN); cmboniv.setPreferredSize(new Dimension( 400 , 200));
     
      lbnumc.setBounds(30,70,120,25);  p.add(lbnumc);  lbnumc.setFont(fe);
      cmbonumelv.setBounds(200,70,120,25);p.add(cmbonumelv);
     
      lbtl.setBounds(30,110,120,25);  p.add(lbtl);  lbtl.setFont(fe);
     txttl.setBounds(200,110,120,25);p.add(txttl); txttl.setFont(fe);
     
		
     
     ann.addActionListener(new ActionListener()
     {  
    		@Override
		public void actionPerformed(ActionEvent arg0) {
			
		dispose();
	}
    	 
     });
     
     
     
    // txtrec.setBounds(180,150,110,20);p.add(txtrec);
 
     
     
     //ajout buttons
     
    bten.setBounds(50,160,120,27); p.add(bten); bten.setFont(fe); bten.setBackground(Color.CYAN); 	bten.addActionListener(this); bten.setIcon(new ImageIcon("C:\\Users\\mohakalil\\Desktop\\img\\save.png"));
    ann.setBounds(200,160,120,27); p.add(ann);  ann.setFont(fe);  ann.setBackground(Color.CYAN);     ann.addActionListener(this);
    		
     /*supp.setBounds(180,80,110,20); p.add(supp);
     modif.setBounds(180,110,110,20); p.add(modif);
     rech.setBounds(30,150,110,20);  p.add(rech);*/
     //fer.setBounds(100,190,110,20); p.add(fer);*/
     
     //CONTENU DU PANEL
     
     add(p); 
       
		
		
	}
	
	
	//recherche de numero cours dans le combo
	      private void initCombo(){
		 
		 
			 Statement state;ResultSet res;
			 connection kk=new connection();
			 try {
				state=kk.etablirconnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
						
				state.executeQuery(req1);
				
				res = state.getResultSet();
				while(res.next()){
					cmboniv.addItem(res.getString("Niveau"));
					
				}res.close();state.close();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			try {
				state=kk.etablirconnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
						
				state.executeQuery(req2);
				
				res = state.getResultSet();
				while(res.next()){
					cmbonumelv.addItem(res.getString("num_elv"));
					
				}res.close();state.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	
			
	
	//fermeture de la fenetre
	
	
	
	}


/*static public void main(String[] args) {
	
	fen_Activites_Pratiques f=new fen_Activites_Pratiques();
	f.setVisible(true);
	
}
*/
@Override
public void actionPerformed(ActionEvent a) {

	
	if(a.getSource()==bten)
	{
	
		String n = (String) cmboniv.getSelectedItem();
	    String  n2=(String) cmbonumelv.getSelectedItem();
	    String n3 =txttl.getText();
	


	String requete = "INSERT INTO activite_pratiques VALUES ('"+n+"','"+n2+"','"+n3+"')";
	  Statement state = null;
		try {
			
			 connection kk=new connection();
			 
	state=kk.etablirconnection().createStatement();
				
		  int res =  state.executeUpdate(requete);
		  if(res!=0){
			 //state.execute(requete);
				
				JOptionPane.showMessageDialog(null, "Eneregistrement ajout� avec succ�s", "info", JOptionPane.INFORMATION_MESSAGE);
				
				   
				   txttl.setText("");
		  
		   }
				//res.close();
				state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "info", JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		}

	    
	}

	
}}



	 
















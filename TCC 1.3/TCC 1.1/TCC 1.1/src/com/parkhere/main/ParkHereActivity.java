package com.parkhere.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import com.parkhere.R;
import com.parkhere.lista.Estacionamento;
import com.parkhere.model.Marcador;
import com.parkhere.overlay.AreaOverlay;
import com.parkhere.overlay.ListaMarcadorOverlay;

public class ParkHereActivity extends MapActivity {
	
	private Context contexto;
	private MapView mapa;
	private MapView mapa_dest;
	private MapController controle;
	private ListaMarcadorOverlay listaOverlay;
	private List<Estacionamento> listaEstacionamento;
	private String[] listaEstacionamentoProximo;
	private Estacionamento escolhido;
	private ArrayList<Estacionamento> listaEstacionamentoArray;
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "admin";
	private static final String DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
	private static final String URL ="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=test.mdb;}"; //make an URL to my database test.mdb which must be in your project folder. 
	private int x;
	private int y;
	
	
    @Override
    public void onCreate( Bundle savedInstanceState ) {
    	listaEstacionamento = new ArrayList<Estacionamento>();
        super.onCreate( savedInstanceState );
        setContentView( R.layout.park_here_activity);
    }
    
    
    // Conexao aqui q vai ter que mecher
    
    
	public void conection() throws ClassNotFoundException {
       	int i = 0;
    	Connection conn=null;
    	try {//lot can go wrong here.
    	Class.forName(DRIVER);
    	conn= DriverManager.getConnection(URL, USERNAME, PASSWORD);
    	Statement stmt = conn.createStatement();
    	ResultSet rs = stmt.executeQuery("select * from Estacionamentos");
    	 while ( rs.next() ) {
    	                String l = rs.getString("Id");// your sql record saved as string
    	                System.out.println(l);//writes your sql record 
    	                Estacionamento  e = new Estacionamento();
//    	                e.setEndere�o(rs.getNString(0));
//    	                e.setLatitude(Double.parseDouble(rs.getNString(1)));
//    	                e.setLongitude(Double.parseDouble(rs.getNString(2)));
//    	                e.setNomeEstacionamento(rs.getNString(3));
//    	                e.setPreco(Double.parseDouble(rs.getNString(4)));
//    	                e.setVagas(Integer.parseInt(rs.getNString(5)));
//    	                e.setNomeEstacionamento(rs.getNString(6));
    	                
    	            }
    	conn.close();
    	} catch (SQLException e) {
    	e.printStackTrace();
    	} 
    	}
    
    
    public void buscar (View v)
    {
    	
    	EditText campoEndereco = (EditText) findViewById(R.id.Endereco);
    	String endere�o = campoEndereco.getText().toString();
    	Geocoder geo = new Geocoder(getApplicationContext());

    	setContentView( R.layout.listaestacionamento);
    	
        try {
         	List<Address> addresses = geo.getFromLocationName(endere�o, 5);
           
            
            
            if (addresses.size() > 0) {
            	EscolherDestino(addresses.get(0).getLatitude(),addresses.get(0).getLongitude());


                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    



	private void EscolherDestino(double latitude, double longitude) {
		int tamanhoLista = 0;
		if(listaEstacionamento == null ||listaEstacionamento.size() == 0)
		{
		ListaDeTeste();
		}
		listaEstacionamentoArray = new ArrayList<Estacionamento>();
		for(int i= 0;i < listaEstacionamento.size();i++)
		{
			if(listaEstacionamento.get(i).getLatitude() < latitude + 100 && listaEstacionamento.get(i).getLatitude() > latitude - 100 && listaEstacionamento.get(i).getLongitude() < longitude + 100 && listaEstacionamento.get(i).getLongitude() > longitude - 100)
			{
			 tamanhoLista++;
			}
		}
		
		listaEstacionamentoProximo = new String[tamanhoLista];
		int altura = 0;
		for(int i= 0;i < listaEstacionamento.size();i++)
		{
			if(listaEstacionamento.get(i).getLatitude() < latitude + 100 && listaEstacionamento.get(i).getLatitude() > latitude - 100 && listaEstacionamento.get(i).getLongitude() < longitude + 100 && listaEstacionamento.get(i).getLongitude() > longitude - 100)
			{
				listaEstacionamentoArray.add(altura ,listaEstacionamento.get(i));
				listaEstacionamentoProximo[altura] = ("Nome : "+listaEstacionamento.get(i).getNomeEstacionamento() + "\nEndere�o :" + listaEstacionamento.get(i).getEndere�o() + "\nPre�o : "+ listaEstacionamento.get(i).getPreco() + "\nVagas :" +listaEstacionamento.get(i).getVagas());
				altura++;
			}
		}		
		
		ListView list = (ListView)findViewById(R.id.listView1);
	       
        list.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listaEstacionamentoProximo));
        
        
        
        list.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
        	
        	public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
        		Destinar(position);   
        		setContentView( R.layout.mapa );  	
        		
        	            }
        	        });
        
        	        
	}
	
     
			public void Destinar(int position) {
				// TODO Auto-generated method stub
				escolhido  = listaEstacionamentoArray.get(position);
				    if(escolhido != null)
	                {
				  
				    this.x = (int)Math.round(escolhido.getLatitude());
				    this.y = (int)Math.round(escolhido.getLongitude());
	                Marcador destino = new Marcador(x, y );
	            
	                           
	                ListaMarcadorOverlay listaOverlay = new ListaMarcadorOverlay( getResources().getDrawable( R.drawable.ic_launcher ) );
	                ArrayList<OverlayItem> listaLocais = new ArrayList<OverlayItem>();
	                
	                Marcador itemSP = new Marcador( -23569596,-46646519 );
	                AreaOverlay areaOverlay = new AreaOverlay( contexto, itemSP , destino, 1000F);

	                
	                listaOverlay.setAreaOverlay( areaOverlay );
	                
	                listaLocais.add( new OverlayItem( itemSP, "Teste", "Apenas um teste" ) );
	                listaOverlay.setListaOverlays( listaLocais );
	                
	                
	                getMapa().getOverlays().add( listaOverlay );
	                getMapa().getOverlays().add( areaOverlay );
	                getControle().setCenter( itemSP );
	                getMapa().invalidate();
	                                   
	                setContentView( R.layout.mapa );  	
	             
	    		                                
	                }
			}

	private void ListaDeTeste() {
		
		Estacionamento  est = new Estacionamento();
		est.TESTANDO();
		
		listaEstacionamento.add(est);

		
		
		

	}


	public void mostrar (String texto)
	{
		Toast.makeText(this,"you have selected "+ texto,Toast.LENGTH_LONG).show();
		
	}

	public void mapa(View v)
    {
    	setContentView( R.layout.mapa );  	
    	
        setMapa( (MapView) findViewById( R.id.mapview ) );

    	setControle(getMapa().getController());
        getMapa().setBuiltInZoomControls( true );
        getMapa().setSatellite( false );
        getControle().setZoom(14);
        
       listaOverlay = new ListaMarcadorOverlay( getResources().getDrawable( R.drawable.ic_launcher ) );
        ArrayList<OverlayItem> listaLocais = new ArrayList<OverlayItem>();	
      
        Marcador itemSP = new Marcador( -23569596,-46646519 ); // brigadeiro
          
          AreaOverlay areaOverlay = new AreaOverlay( this, itemSP , null, 1000F);
        
          
          listaOverlay.setAreaOverlay( areaOverlay );
          
          listaLocais.add( new OverlayItem( itemSP, "Teste", "Apenas um teste" ) );
          listaOverlay.setListaOverlays( listaLocais );
          
        
                
          
        getMapa().getOverlays().add( areaOverlay );
        
        getMapa().getOverlays().add( listaOverlay );

        getControle().setCenter( itemSP );
        getMapa().invalidate();

        
        
       }

	public void mapaExemplo(View v)
    {
    	setContentView( R.layout.mapa );  	
    	
        setMapa( (MapView) findViewById( R.id.mapview ) );

    	setControle(getMapa().getController());
        getMapa().setBuiltInZoomControls( true );
        getMapa().setSatellite( false );
        getControle().setZoom(14);
        
       listaOverlay = new ListaMarcadorOverlay( getResources().getDrawable( R.drawable.ic_launcher ) );
        ArrayList<OverlayItem> listaLocais = new ArrayList<OverlayItem>();	
      
        Marcador itemSP = new Marcador( -23569596,-46646519 ); // brigadeiro
        Marcador destino = new Marcador(-23566300, -46646400 );
          
          AreaOverlay areaOverlay = new AreaOverlay( this, itemSP , destino, 1000F);
        
          
          listaOverlay.setAreaOverlay( areaOverlay );
          
          listaLocais.add( new OverlayItem( itemSP, "Teste", "Apenas um teste" ) );
          listaOverlay.setListaOverlays( listaLocais );
          
        
                
          
        getMapa().getOverlays().add( areaOverlay );
        
        getMapa().getOverlays().add( listaOverlay );

        getControle().setCenter( itemSP );
        getMapa().invalidate();

        
        
       }

    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        getMenuInflater().inflate( R.menu.park_here_activity, menu );
        return true;
    }

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
	
	public MapView getMapa() {
		return mapa;
	}

	public void setMapa( MapView mapa ) {
		this.mapa = mapa;
	}
	public void Sair(View v)
	{
		System.exit(0);
	}
	   	                
		
	public void voltar(View v)
	{
		 setContentView( R.layout.park_here_activity );
	}

	public void Creditos(View v)
	{
		 setContentView( R.layout.creditos );
	}
	

	public MapController getControle() {
		return controle;
	}

	public void setControle( MapController controle ) {
		this.controle = controle;
	}

	public Context getContexto() {
		return contexto;
	}

	public void setContexto( Context contexto ) {
		this.contexto = contexto;
	}


	public MapView getMapa_dest() {
		return mapa_dest;
	}


	public void setMapa_dest(MapView mapa_dest) {
		this.mapa_dest = mapa_dest;
	}
}

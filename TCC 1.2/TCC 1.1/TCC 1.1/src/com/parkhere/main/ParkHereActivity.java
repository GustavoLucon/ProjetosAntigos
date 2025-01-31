package com.parkhere.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.util.FloatMath;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import com.google.android.maps.Projection;
import com.parkhere.R;
import com.parkhere.lista.Estacionamento;
import com.parkhere.model.Marcador;
import com.parkhere.overlay.AreaOverlay;
import com.parkhere.overlay.ListaMarcadorOverlay;

public class ParkHereActivity extends MapActivity {
	
	private Context contexto;
	private MapView mapa;
	private MapController controle;
	private ListaMarcadorOverlay listaOverlay;
	private List<Estacionamento> listaEstacionamento;
	private String[] listaEstacionamentoProximo;
	private Estacionamento escolhido;
	
	
    @Override
    public void onCreate( Bundle savedInstanceState ) {
    	listaEstacionamento = new ArrayList<Estacionamento>();
        super.onCreate( savedInstanceState );
        setContentView( R.layout.park_here_activity );
    }
    
    
    public void buscar (View v)
    {
    	EditText campoEndereco = (EditText) findViewById(R.id.campoEndereco);
    	String endere�o = campoEndereco.getText().toString();
    	Geocoder geo = new Geocoder(getApplicationContext());

    	 setContentView( R.layout.listaestacionamento);
    	
        try {
         	GeoPoint p;
            List<Address> addresses = geo.getFromLocationName(endere�o, 5);
           
            
            
            if (addresses.size() > 0) {
                p = EscolherDestino(addresses.get(0).getLatitude(),addresses.get(0).getLongitude());
                if(p != null)
                {
                Marcador destino = new Marcador(p.getLatitudeE6() , p.getLongitudeE6() );
            
                           
                ListaMarcadorOverlay listaOverlay = new ListaMarcadorOverlay( getResources().getDrawable( R.drawable.ic_launcher ) );
                ArrayList<OverlayItem> listaLocais = new ArrayList<OverlayItem>();
                
                Marcador itemSP = new Marcador( -23569596,-46646519 );
                AreaOverlay areaOverlay = new AreaOverlay( this, itemSP , destino, 1000F);

                
                listaOverlay.setAreaOverlay( areaOverlay );
                
                listaLocais.add( new OverlayItem( itemSP, "Teste", "Apenas um teste" ) );
                listaOverlay.setListaOverlays( listaLocais );
                

                      
                
                getMapa().getOverlays().add( listaOverlay );
                getMapa().getOverlays().add( areaOverlay );
                getControle().setCenter( itemSP );
                getMapa().invalidate();

                }
            
            
            
            }    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    



	private GeoPoint EscolherDestino(double latitude, double longitude) {
		int tamanhoLista = 0;
		ListaDeTeste();
		final List<Estacionamento> listaEstacionamentoArray = new ArrayList<Estacionamento>();
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
        
        
        list.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				escolhido  = listaEstacionamentoArray.get(arg2);
				
			}
        });
        GeoPoint local= null ;
		if(escolhido != null)
		{
        int x = (int)Math.round(escolhido.getLongitude());
        int y = (int)Math.round(escolhido.getLongitude());
		local = new GeoPoint(x, y);
		}
		return local;
	}

	private void ListaDeTeste() {
		
		Estacionamento  est = new Estacionamento();
		est.TESTANDO();
		
		listaEstacionamento.add(est);
		listaEstacionamento.add(est);
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

    	setControle( getMapa().getController() );
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
}

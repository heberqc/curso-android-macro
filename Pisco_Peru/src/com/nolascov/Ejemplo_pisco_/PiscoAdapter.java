package com.nolascov.Ejemplo_pisco_;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public final class PiscoAdapter extends ArrayAdapter<PiscoEntry> {

    private final int piscoEntryLayout;
    private static PiscoHolder viewHolder;

    public PiscoAdapter( final Context context, final int idLayout ) {
        super(context, 0);
        piscoEntryLayout = idLayout;
    }

    // devolver la instancia View con datos, para ser mostrada en la lista
    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
    	//recuperar su correspondiente ViewHolder , lo que optimiza la eficiencia de búsqueda
        final View view = getWorkingView(convertView);
        viewHolder = getViewHolder(view);
        final PiscoEntry entry = getItem(position);
       //Configuración de la vista del título es sencillo
        viewHolder.titleView.setText(entry.getTitle());
        //Configuración de la vista de subtítulos requiere un poco de formato
        viewHolder.subTitleView.setText( entry.getAuthor() );
        //Configuración de vista de la imagen también es sencillo
        viewHolder.imageView.setImageResource(entry.getIcon());
        return view;
    }

    // obtener la vista de trabajo
    public final View getWorkingView(final View convertView) {
    	//El workingView es básicamente la convertView volver a utilizar si es posible 
    	//o inflado nueva si no es posible
        View workingView = null;

        if( convertView instanceof View ) {
            workingView = convertView;
        } else {
            final LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            workingView = inflater.inflate(piscoEntryLayout, null);
        }
        return workingView;
    }
	
    // obtener el objeto guardado en este View
    public final PiscoHolder getViewHolder(final View workingView) {
    	// El viewHolder nos permite evitar el repitando hace referencia a que miran para arriba 
        // A partir de puntos de vista son reciclados, estas referencias no va a cambiar
        final Object tag = workingView.getTag();
        viewHolder = null;

        if( !(tag instanceof PiscoHolder) ) {
            viewHolder = new PiscoHolder();

            viewHolder.titleView = (TextView) workingView.findViewById(R.id.titulo);
            viewHolder.subTitleView = (TextView) workingView.findViewById(R.id.subtitulo);
            viewHolder.imageView = (ImageView) workingView.findViewById(R.id.icono);

            workingView.setTag(viewHolder);
        } else {
            viewHolder = (PiscoHolder)tag;
        }

        return viewHolder;
    }
	
}
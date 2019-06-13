package examples.android.example.com.multiplerecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;


public class Adapter extends RecyclerView.Adapter<Adapter.OldViewHolder> {

    private Context context;

    List<My_items> items;

//    private static int TYPE_PIC = 1;
//    private static int TYPE_DESC = 2;


    public Adapter(List<My_items> details){

        if(details!=null){

            items=details;
        }

        else{
            System.out.println("#Adapter Data is null");
        }

    }

    @NonNull
    @Override
    public OldViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

//        View view;
//        if (i == TYPE_PIC) {
//            view = LayoutInflater.from(context).inflate(R.layout.image_name, viewGroup, false);
//            return new PicViewHolder(view);
//
//        } else { // for email layout
//            view = LayoutInflater.from(context).inflate(R.layout.name_description, viewGroup, false);
//            return new DescViewHolder(view);
//        }

        context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.name_description;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, viewGroup, false);

        return new OldViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull OldViewHolder viewHolder, int i) {


//        @BindView(R.id.nameImage)
//        TextView name;

//        if (getItemViewType(i) == TYPE_PIC) {
//            ((PicViewHolder) viewHolder).setPicDetails(items.get(i));
//        } else {
//            ((DescViewHolder) viewHolder).setDescDetails(items.get(i));
//        }


        viewHolder.setDescDetails(items,viewHolder.getAdapterPosition());


    }





    @Override
    public int getItemCount()

    {

        return items.size();
    }


//    @Override
//    public int getItemViewType(int position) {
//        if (TextUtils.isEmpty(items.get(position).getPicName()) ){
//            return TYPE_DESC;
//
//        } else {
//            return TYPE_PIC;
//        }
//    }


//    class OldViewHolder extends RecyclerView.ViewHolder {
//
//        private ImageView PicUrl;
//        private TextView txtPicName;
//
//        OldViewHolder(@NonNull View itemView) {
//            super(itemView);
//            PicUrl = itemView.findViewById(R.id.image);
//            txtPicName = itemView.findViewById(R.id.nameImage);
//        }
//
//
//        private void setPicDetails(My_items ii) {
//            // txt.setText(ii.getPicName());
//            txtPicName.setText(ii.getPicName());
//        }
//    }

    class OldViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;
        private TextView txtDesc;

       private  OldViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.name);
            txtDesc = itemView.findViewById(R.id.description);
        }

        private void setDescDetails(List<My_items> items ,int pos) {
            txtName.setText(items.get(pos).getName());
            txtDesc.setText(items.get(pos).getDescription());
        }
    }
}

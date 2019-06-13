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

public class OldAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;

    List<My_items> items;

    private static int TYPE_PIC = 1;
    private static int TYPE_DESC = 2;


    public OldAdapter(List<My_items> details){

        if(details!=null){

            items=details;
        }

        else{
            System.out.println("#Adapter Data is null");
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        context = viewGroup.getContext();

        View view;
        if (i == TYPE_PIC) {
            view = LayoutInflater.from(context).inflate(R.layout.image_name, viewGroup, false);
            return new OldAdapter.PicViewHolder(view);

        } else { //
            view = LayoutInflater.from(context).inflate(R.layout.name_description, viewGroup, false);
            return new OldAdapter.DescViewHolder(view);
        }


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {


//        @BindView(R.id.nameImage)
//        TextView name;




        if (getItemViewType(i) == TYPE_PIC) {
            ((OldAdapter.PicViewHolder) viewHolder).setPicDetails(items.get(i));
        } else {
            ((OldAdapter.DescViewHolder) viewHolder).setDescDetails(items, i);
        }



    }





    @Override
    public int getItemCount() {
        return items.size();
    }


    @Override
    public int getItemViewType(int position) {
        if (TextUtils.isEmpty(items.get(position).getPicName()) ){
            return TYPE_DESC;

        } else {
            return TYPE_PIC;
        }
    }


    class PicViewHolder extends RecyclerView.ViewHolder {

        private ImageView PicUrl;
        private TextView txtPicName;

        PicViewHolder(@NonNull View itemView) {
            super(itemView);
            PicUrl = itemView.findViewById(R.id.image);
            txtPicName = itemView.findViewById(R.id.nameImage);
        }


        private void setPicDetails(My_items ii) {
            // txt.setText(ii.getPicName());
            txtPicName.setText(ii.getPicName());
        }
    }

    class DescViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;
        private TextView txtDesc;

        DescViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.name);
            txtDesc = itemView.findViewById(R.id.description);
        }

        private void setDescDetails(List<My_items> items, int pos) {
            txtName.setText(items.get(pos).getName());
            txtDesc.setText(items.get(pos).getDescription());
        }
    }
}

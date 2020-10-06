package na.severinchik.listsample.adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import na.severinchik.listsample.Purse;
import na.severinchik.listsample.R;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PurseAdapter extends RecyclerView.Adapter<ViewHolder> {

    private static final int DEFAULT_TYPE = 0;
    private static final int FUll_TYPE = 1;
    List<Integer> stateViewHolders;
    List<Purse> purseList;

    public PurseAdapter(List<Purse> purseList) {
        this.purseList = purseList;
        stateViewHolders = new ArrayList<>(Arrays.asList(new Integer[purseList.size()]));
        Collections.fill(stateViewHolders, DEFAULT_TYPE);
    }

    @Override
    public int getItemViewType(int position) {
        if(stateViewHolders.get(position)==FUll_TYPE){
            return R.layout.full_item_list;
        }
        return R.layout.default_item_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);

        switch (viewType) {
            case R.layout.full_item_list:
                return new FullViewHolder(view);
            default:
                return new DefaultViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Purse purse = purseList.get(position);
        if (holder instanceof FullViewHolder) {
            ((FullViewHolder) holder).bind(purse, position);
        } else {
            ((DefaultViewHolder) holder).bind(purse, position);
        }
    }

    @Override
    public int getItemCount() {
        return purseList.size();
    }

    class FullViewHolder extends ViewHolder {
        EditText name;
        ImageView avatar;
        EditText key;
        Button submit;
        Button delete;


        public FullViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.full_item_name);
            avatar = itemView.findViewById(R.id.full_item_avatar);
            key = itemView.findViewById(R.id.full_item_key);
            submit = itemView.findViewById(R.id.full_item_submit);
            delete = itemView.findViewById(R.id.full_item_delete);
        }

        void bind(Purse purse, int position) {
            name.setText(purse.getName());
            key.setText(purse.getKey());

            submit.setOnClickListener(view -> {
                stateViewHolders.set(position, DEFAULT_TYPE);
                notifyItemChanged(position);
            });

            delete.setOnClickListener(view -> {
                purseList.remove(position);
                stateViewHolders.remove(position);
                notifyItemChanged(position);
                notifyItemRangeChanged(position, purseList.size());
            });
        }
    }

    class DefaultViewHolder extends ViewHolder {
        TextView name;
        ImageView avatar;
        View view;

        public DefaultViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.default_item_name);
            avatar = itemView.findViewById(R.id.default_item_avatar);
            view = itemView;
        }

        void bind(Purse purse, int position) {
            name.setText(purse.getName());
            view.setOnClickListener(v -> {
                stateViewHolders.set(position, FUll_TYPE);
                notifyItemChanged(position);
            });

        }
    }


}


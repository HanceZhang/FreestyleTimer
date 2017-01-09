package adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.application.myapplication.BR;
import com.example.application.myapplication.R;

import java.util.List;

import Models.Artifact;

/**
 * Created by Hance on 2017-01-05.
 */

public class ArtifactAdapter extends RecyclerView.Adapter<ArtifactAdapter.ViewHolder> {
    private List<Artifact> artifactList;

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ViewDataBinding binding;

        public ViewHolder(View v) {
            super(v);
            binding = DataBindingUtil.bind(v);
        }
        public ViewDataBinding getBinding() {
            return binding;
        }
    }

    public ArtifactAdapter (List<Artifact> artifactList){
        this.artifactList = artifactList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.artifact_list_row,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Artifact artifact = artifactList.get(position);
        holder.getBinding().setVariable(BR.artifact, artifact);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return artifactList.size();
    }
}

package com.blog.dm.mg_coordinatorlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Mac on 8/3/2015.
 */
public class DummyFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private DummyDataAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_layout_dummy,container,false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        mLinearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mAdapter = new DummyDataAdapter();

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }


    public class DummyDataAdapter extends RecyclerView.Adapter<DummyDataAdapter.DummyViewHolder>{


        @Override
        public DummyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.layout_dummy_card, parent, false);
            DummyViewHolder holder = new DummyViewHolder(view);

            return holder;
        }

        @Override
        public void onBindViewHolder(DummyViewHolder holder, int position) {
            holder.mdummyText.setText("This is the item at: "+position);
        }

        @Override
        public int getItemCount() {
            return 10;
        }

        public class DummyViewHolder extends RecyclerView.ViewHolder{

            public TextView mdummyText;

            public DummyViewHolder(View itemView){
                super(itemView);
                mdummyText = (TextView) itemView.findViewById(R.id.dummy_text);

            }
        }
    }
}

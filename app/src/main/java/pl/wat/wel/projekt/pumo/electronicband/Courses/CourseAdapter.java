package pl.wat.wel.projekt.pumo.electronicband.Courses;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pl.wat.wel.projekt.pumo.electronicband.R;

/**
 * Created by Damian Bondaruk on 2017-05-24.
 */

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.MyViewHolder> {
    private final OnItemClickListener onItemClickListener;
    private List<CourseModel> courseList;

    public CourseAdapter(List<CourseModel> courseList, OnItemClickListener onItemClickListener) {
        this.courseList = courseList;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.courses_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CourseModel list = courseList.get(position);

        holder.tittle.setText(list.getTittle());
        holder.image.setImageResource(list.getImageId());
        holder.bind(courseList.get(position), onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(CourseModel item);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tittle;
        ImageView image;

        MyViewHolder(View view) {
            super(view);
            tittle = (TextView) view.findViewById(R.id.course_tittle);
            image = (ImageView) view.findViewById(R.id.course_image);
        }

        public void bind(final CourseModel item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });

        }


    }


}

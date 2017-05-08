package com.github.rayboot.project.BuilderParty.adapter.cell;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.DraweeView;
import com.github.rayboot.project.BuilderParty.adapter.holder.BaseHolder;
import com.github.rayboot.project.BuilderParty.model.BookModel;
import com.github.rayboot.project.R;

/**
 * Created by liupei on 2017/5/8.
 */

public class StudyInfoCell extends BaseCell{
    private BookModel bookModel;

    public StudyInfoCell(Context context, BookModel bookModel) {
        this.mContext = context;
        this.bookModel = bookModel;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public BaseHolder OncreateViewHolder(ViewGroup viewGroup, int itemType) {
        View itemView = inflater.inflate(R.layout.makebook_studyinfo, viewGroup, false);
        return new BaseHolder(itemView);
    }

    @Override
    public void OnBindData(BaseHolder baseHolder, int position) {
        DraweeView make_studyinfo_dv = baseHolder.getDraweeView(R.id.make_studyinfo_dv);
        TextView make_studyinfo_tv = baseHolder.getTextView(R.id.make_studyinfo_tv);

        make_studyinfo_dv.setImageURI(Uri.parse(bookModel.getContent_icon()));
        make_studyinfo_tv.setText(bookModel.getContent_title());
    }

    @Override
    public int getItemType() {
        return 1;
    }
}

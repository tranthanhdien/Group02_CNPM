package com.example.mp3app.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mp3app.activity.PlayNhacActivity;
import com.example.mp3app.model.BaiHat;
import com.example.mp3app.R;
import com.example.mp3app.service.APIService;
import com.example.mp3app.service.DataService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaiHatAdapter extends RecyclerView.Adapter<BaiHatAdapter.ViewHolder> {
    Context context;
    ArrayList<BaiHat> listBaiHat;

    public BaiHatAdapter(Context context, ArrayList<BaiHat> listBaiHat) {
        this.context = context;
        this.listBaiHat = listBaiHat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.line_song, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiHat baihat = listBaiHat.get(position);
        holder.txtNameSong.setText(baihat.getTenBaiHat());
        holder.txtAuthorSong.setText(baihat.getCaSi());
        Picasso.get().load(baihat.getHinhCaSi()).into(holder.imgSong);
    }

    @Override
    public int getItemCount() {
        return listBaiHat.size();
    }

    // class view holder để tăng tóc độ ánh xạ các component
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNameSong, txtAuthorSong;
        ImageView imgSong, imgLuotThich;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameSong = itemView.findViewById(R.id.txtNameSong);
            txtAuthorSong = itemView.findViewById(R.id.txtAuthorSong);
            imgSong = itemView.findViewById(R.id.imgSong);
            imgLuotThich = itemView.findViewById(R.id.imgLuotThich);

            // sự kiện khi nhấn vào icon lượt thích
            imgLuotThich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(context, listBaiHat.get(getPosition()).getTenBaiHat(), Toast.LENGTH_LONG).show();
                    // khi click vào thì sẽ đổi thành trái tim đỏ
                    imgLuotThich.setImageResource(R.drawable.iconloved);
                    // tương tác lên Server update lại lượt thích
                    DataService dataService = APIService.getService();
                    // chỉ update 1 lần 1 lượt thích, update theo id bài hát
                    Call<String> callBack = dataService.updateLuotThich("1", listBaiHat.get(getPosition()).getIdBaiHat());
                    // gửi lên Server
                    callBack.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            // kết quả trả về
                            String result = response.body();
                            if (response.equals("Sucess")) {
                                Toast.makeText(context, "Loved!", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(context, "Error!", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Toast.makeText(context, "Error: " + call.toString(), Toast.LENGTH_LONG).show();
                        }
                    });
                    // sau khi đã thích thì set  lại disable
                    imgLuotThich.setEnabled(false);
                }
            });

            // xử lí khi nhấn vào từng item bài hát
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // chuyển dữ liệu qua màn hình play nhạc
                    Intent intent = new Intent(context, PlayNhacActivity.class);
                    // truyền nguyên đối tượng bài hát qua màn hình Play nhac
                    intent.putExtra("baihat", listBaiHat.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }

}

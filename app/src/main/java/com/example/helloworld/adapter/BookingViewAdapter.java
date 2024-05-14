package com.example.helloworld.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.R;
import com.example.helloworld.model.BookingFormActivity;

import com.example.helloworld.model.ViewBookingData;

import java.util.List;

public class BookingViewAdapter extends RecyclerView.Adapter<BookingViewAdapter.BookingViewHolder>{


    Context context;
    List<ViewBookingData> viewBookingDataList;
    public BookingViewAdapter(Context context, List<ViewBookingData> viewBookingDataList) {
        this.context = context;
        this.viewBookingDataList = viewBookingDataList;
    }



    @NonNull
    @Override
    public BookingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.bookig_view_card, parent, false);

        // here we create a recyclerview row item layout file
        return new BookingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingViewHolder holder, int position) {


        holder.mem_Name.setText("Name: "+viewBookingDataList.get(position).getMem_name());
        holder.mem_Nic.setText("NIC: "+viewBookingDataList.get(position).getMem_nic());
        holder.hotel_name.setText("Booked Hotel: "+viewBookingDataList.get(position).getHotel_name());
        holder.room_type.setText("Room Type: "+viewBookingDataList.get(position).getRoom_type());
        holder.num_rooms.setText("No.of Rooms: "+String.valueOf(viewBookingDataList.get(position).getNo_of_rooms()));
        holder.booking_date.setText("Booking Date"+viewBookingDataList.get(position).getDate());
        holder.payment.setText("Payments:"+ String.valueOf(viewBookingDataList.get(position).getPayment()));
        holder.booking_id.setText("Booking Id"+String.valueOf(viewBookingDataList.get(position).getBookingId()));

    }

    @Override
    public int getItemCount() {
        return viewBookingDataList.size();
    }

    public static final class BookingViewHolder extends RecyclerView.ViewHolder{
        TextView booking_id, mem_Name, mem_Nic, hotel_name,room_type, num_rooms,booking_date,payment;

        public BookingViewHolder(@NonNull View itemView) {
            super(itemView);

            booking_id = itemView.findViewById(R.id.booking_id);
            mem_Name = itemView.findViewById(R.id.mem_name);
            mem_Nic = itemView.findViewById(R.id.mem_nic);
            hotel_name = itemView.findViewById(R.id.view_hotel_name);
            room_type = itemView.findViewById(R.id.view_room_type);
            num_rooms = itemView.findViewById(R.id.no_of_rooms);
            booking_date = itemView.findViewById(R.id.booking_date);
            payment = itemView.findViewById(R.id.payment);


        }
    }
}



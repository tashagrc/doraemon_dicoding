package com.example.doraemon_dicoding;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Alat implements Parcelable {
    private String title;
    private String desc;
    private int image;

    public Alat() {

    }

    protected Alat(Parcel in) {
        title = in.readString();
        desc = in.readString();
        image = in.readInt();
    }

    public static final Creator<Alat> CREATOR = new Creator<Alat>() {
        @Override
        public Alat createFromParcel(Parcel in) {
            return new Alat(in);
        }

        @Override
        public Alat[] newArray(int size) {
            return new Alat[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(desc);
        parcel.writeInt(image);
    }
}

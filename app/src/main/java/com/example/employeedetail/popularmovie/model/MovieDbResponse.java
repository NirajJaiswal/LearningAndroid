package com.example.employeedetail.popularmovie.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieDbResponse implements Parcelable
{

@SerializedName("page")
@Expose
private Integer page;
@SerializedName("total_results")
@Expose
private Integer totalMovies;
@SerializedName("total_pages")
@Expose
private Integer totalPages;
@SerializedName("results")
@Expose
private List<Movie> results = null;
public final static Parcelable.Creator<MovieDbResponse> CREATOR = new Creator<MovieDbResponse>() {


@SuppressWarnings({
"unchecked"
})
public MovieDbResponse createFromParcel(Parcel in) {
return new MovieDbResponse(in);
}

public MovieDbResponse[] newArray(int size) {
return (new MovieDbResponse[size]);
}

}
;

protected MovieDbResponse(Parcel in) {
this.page = ((Integer) in.readValue((Integer.class.getClassLoader())));
this.totalMovies = ((Integer) in.readValue((Integer.class.getClassLoader())));
this.totalPages = ((Integer) in.readValue((Integer.class.getClassLoader())));
in.readList(this.results, (com.example.employeedetail.popularmovie.model.Movie.class.getClassLoader()));
}

public MovieDbResponse() {
}

public Integer getPage() {
return page;
}

public void setPage(Integer page) {
this.page = page;
}

public Integer getTotalMovies() {
return totalMovies;
}

public void setTotalMovies(Integer totalMovies) {
this.totalMovies = totalMovies;
}

public Integer getTotalPages() {
return totalPages;
}

public void setTotalPages(Integer totalPages) {
this.totalPages = totalPages;
}

public List<Movie> getMovies() {
return results;
}

public void setMovies(List<Movie> results) {
this.results = results;
}

public void writeToParcel(Parcel dest, int flags) {
dest.writeValue(page);
dest.writeValue(totalMovies);
dest.writeValue(totalPages);
dest.writeList(results);
}

public int describeContents() {
return 0;
}

}
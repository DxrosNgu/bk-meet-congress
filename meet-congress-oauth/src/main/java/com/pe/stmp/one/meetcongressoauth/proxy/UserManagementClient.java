package com.pe.stmp.one.meetcongressoauth.proxy;

// import com.github.lianjiatech.retrofit.spring.boot.annotation.Intercept;
// import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
// import com.pe.stmp.one.meetcongressoauth.event.TimeStampInterceptor;
import com.pe.stmp.one.meetcongressoauth.models.User;
import kotlin.Result;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.*;


// @RetrofitClient(baseUrl = "http://localhost:8190/api/users/")
// @Intercept(handler = TimeStampInterceptor.class, include = {"/api/users/**"}, exclude = "/proxy/test/UserManagementClient")
@Component
public interface UserManagementClient {

    @GET("find-by-user")
    @Headers({"Content-Type:application/json"})
    Call<User> findByUsername(@Query("user") String username);

    @PUT("users/{id}")
    @Headers({"Content-Type:application/json"})
    Call<User> update(@Body User user, @Path("id") Long idUser);

}

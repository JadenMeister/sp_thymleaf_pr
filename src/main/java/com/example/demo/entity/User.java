package com.example.demo.entity;

// User라는 공개 클래스 선언
public class User {
  // private = 외부 접근 불가, 클래스 내부에서만 사용가능함
    private String name;
    private String username;
    private String password;

// 기본 생성자 ** 매개병수 없이 new User() 호 시 사용  Spring에서 객체를 생성할 때 사용
    // 생성자 : 객체를 생성할 때 호출되는 메소드
    public User(){}


    // getter: private 변수에 접근하기 위한 메서드  ** 왜 필요? -> private 변수는 외부에서 접근이 불가하기 때문에 직접 접근 불가, 간접 접근을 위함
    public String getUsername() {
        return username;
    }
    // setter: private 변수에 값을 설정하기 위한 메서드. Spring에서 폼데이터에 객체를 넣릏 때 setter 사용
    public void setUsername(String username){
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
}

}
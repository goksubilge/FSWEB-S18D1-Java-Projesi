package com.wit.burgerapp.dto;

// yalnızca getter ve setter ları vardır Record ların. Data taşıyacaksan çokidealler. Normal class da olurdu burada şuan, ama recor kkullanımı için ideal bir yer burası o yüzden burda gösterdik.
// Controller 'da @GetMapping("/") i düzenliyorum gidip. List<BurgerResponse> olarak. Sonra da bir convertion yapacağım. Convertion işlemi de Controller 'da yazpılmaz. util package altında bir class açarız. BurgerResponseEntity olarak o class 'ta yazarız.

public record BurgerResponse(String name, double price) {
}

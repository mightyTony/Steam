package tony.project.steam.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                title = "스팀 API",
                version = "1.0",
                description = "스팀 API"
        )
)
public class SwaggerConfig {

    @Profile({"local","dev"})
    @Bean
    public OpenAPI devOpenAPI() {

        Info info = new Info()
                .version("v1.0.0")  // 문서 버전
                .title("스팀 REST API Swagger") // 문서 제목
                .description("스팀 API 문서입니다.")// 문서 설명
                .contact(new Contact());

        // 스웨거에서 인증(Authorize) 버튼 세팅
        String jwtSchemeName = "Authorization";
        String refreshName = "Refresh";

        // API 요청 헤더에 인증 정보 포함
        SecurityRequirement securityRequirement = new SecurityRequirement().addList(jwtSchemeName).addList(refreshName); // 헤더에 토큰 포함

        // SecurityScheme 등록
        Components components = new Components()
                .addSecuritySchemes(jwtSchemeName, new SecurityScheme()
                        .name(jwtSchemeName)
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT"))
                .addSecuritySchemes(refreshName, new SecurityScheme()
                        .name(refreshName)
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("REFRESH"));

        return new OpenAPI()
                .info(info)
                .addSecurityItem(securityRequirement)
                .addServersItem(new Server().url("http://localhost:8080").description("Development server (HTTP)"))
                .components(components);
    }

    @Profile("prod")
    @Bean
    public OpenAPI prodOpenAPI() {
        // FIXME
        //  참고 https://velog.io/@juhyeon1114/Springdoc%EC%9C%BC%EB%A1%9C-Swagger%EB%AC%B8%EC%84%9C-%EC%83%9D%EC%84%B1%ED%95%98%EA%B8%B0-Spring-boot-3.0-%EC%9D%B4%EC%83%81

        Info info = new Info()
                .version("v1.0.0")  // 문서 버전
                .title("시스템 REST API Swagger") // 문서 제목
                .description("설명 란")// 문서 설명
                .contact(new Contact());

        // 스웨거에서 인증(Authorize) 버튼 세팅
        String jwtSchemeName = "Authorization";
        String refreshName = "Refresh";

        // API 요청 헤더에 인증 정보 포함
        SecurityRequirement securityRequirement = new SecurityRequirement().addList(jwtSchemeName).addList(refreshName); // 헤더에 토큰 포함

        // SecurityScheme 등록
        Components components = new Components()
                .addSecuritySchemes(jwtSchemeName, new SecurityScheme()
                        .name(jwtSchemeName)
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT"))
                .addSecuritySchemes(refreshName, new SecurityScheme()
                        .name(refreshName)
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("REFRESH"));

        return new OpenAPI()
                .info(info)
                .addSecurityItem(securityRequirement)
                //FIXME : 서버 주소 변경
                .addServersItem(new Server().url("https://spring.tonyworld.kr"))
                .components(components);
    }

}

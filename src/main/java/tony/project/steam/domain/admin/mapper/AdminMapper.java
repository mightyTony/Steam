package tony.project.steam.domain.admin.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    boolean existCheckByGameName(String gameName);
}

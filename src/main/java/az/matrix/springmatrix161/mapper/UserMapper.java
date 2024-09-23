package az.matrix.springmatrix161.mapper;

import az.matrix.springmatrix161.dto.UserDto;
import az.matrix.springmatrix161.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class UserMapper {

    public abstract User toEntity(UserDto dto);

    public abstract UserDto toDto(User user);

    public abstract void mapForUpdate(@MappingTarget User user, UserDto dto);

}

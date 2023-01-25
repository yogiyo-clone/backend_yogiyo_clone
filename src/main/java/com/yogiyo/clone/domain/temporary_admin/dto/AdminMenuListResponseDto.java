package com.yogiyo.clone.domain.temporary_admin.dto;

import com.yogiyo.clone.domain.temporary_admin.entity.Store_menu;
import lombok.Getter;

@Getter
public class AdminMenuListResponseDto {

    private Long menu_id;
    private String menu_name;

    public AdminMenuListResponseDto(Store_menu menu) {
        this.menu_id = menu.getId();
        this.menu_name = menu.getMenu_name();
    }
}
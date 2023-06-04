-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('挂号', '3', '1', 'reg', 'system/reg/index', 1, 0, 'C', '0', '0', 'doc:reg:list', '#', 'admin', sysdate(), '', null, '挂号菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('挂号查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'doc:reg:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('挂号新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'doc:reg:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('挂号修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'doc:reg:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('挂号删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'doc:reg:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('挂号导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'doc:reg:export',       '#', 'admin', sysdate(), '', null, '');
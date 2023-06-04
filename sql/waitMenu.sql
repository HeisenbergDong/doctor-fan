-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('排队', '3', '1', 'wait', 'system/wait/index', 1, 0, 'C', '0', '0', 'system:wait:list', '#', 'admin', sysdate(), '', null, '排队菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('排队查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:wait:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('排队新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:wait:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('排队修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:wait:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('排队删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:wait:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('排队导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:wait:export',       '#', 'admin', sysdate(), '', null, '');
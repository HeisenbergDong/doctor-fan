-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('提醒', '3', '1', 'remind', 'system/remind/index', 1, 0, 'C', '0', '0', 'doc:remind:list', '#', 'admin', sysdate(), '', null, '提醒菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('提醒查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'doc:remind:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('提醒新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'doc:remind:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('提醒修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'doc:remind:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('提醒删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'doc:remind:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('提醒导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'doc:remind:export',       '#', 'admin', sysdate(), '', null, '');
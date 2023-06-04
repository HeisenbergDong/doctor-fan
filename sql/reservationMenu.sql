-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('预约', '3', '1', 'reservation', 'system/reservation/index', 1, 0, 'C', '0', '0', 'doc:reservation:list', '#', 'admin', sysdate(), '', null, '预约菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('预约查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'doc:reservation:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('预约新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'doc:reservation:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('预约修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'doc:reservation:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('预约删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'doc:reservation:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('预约导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'doc:reservation:export',       '#', 'admin', sysdate(), '', null, '');
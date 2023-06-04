-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('推荐人折扣积分', '3', '1', 'point', 'system/point/index', 1, 0, 'C', '0', '0', 'system:point:list', '#', 'admin', sysdate(), '', null, '推荐人折扣积分菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('推荐人折扣积分查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:point:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('推荐人折扣积分新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:point:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('推荐人折扣积分修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:point:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('推荐人折扣积分删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:point:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('推荐人折扣积分导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:point:export',       '#', 'admin', sysdate(), '', null, '');
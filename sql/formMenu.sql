-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('单', '3', '1', 'form', 'system/form/index', 1, 0, 'C', '0', '0', 'doc:form:list', '#', 'admin', sysdate(), '', null, '单菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('单查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'doc:form:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('单新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'doc:form:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('单修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'doc:form:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('单删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'doc:form:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('单导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'doc:form:export',       '#', 'admin', sysdate(), '', null, '');
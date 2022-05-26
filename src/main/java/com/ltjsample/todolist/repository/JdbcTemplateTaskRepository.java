package com.ltjsample.todolist.repository;

import com.ltjsample.todolist.domain.Task;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JdbcTemplateTaskRepository implements TaskRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateTaskRepository(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Task add(Task task) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("task").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("explain", task.getExplain());
        parameters.put("state", task.getState());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        task.setId(key.longValue());
        return task;
    }

    @Override
    public void setState(Long id, String state) {
        String sql = "UPDATE task SET state = ? WHERE id = ?";
        int result = jdbcTemplate.update(sql, state, id);

        if(result <= 0)
            System.out.println("JdbcTemplateTaskRepository : setState 결과가 0개 이하이다.");
    }

    @Override
    public void delete(Long id) {
        String sql = "delete task where id = ?";
        int result = jdbcTemplate.update(sql,id);
        if(result <= 0)
            System.out.println("JdbcTemplateTaskRepository : delete 결과가 0개 이하이다.");
    }

    @Override
    public Optional<Task> findById(Long id) {
        List<Task> result = jdbcTemplate.query("select * from task where id = ?", taskRowMapper(), id);
        return result.stream().findAny();
    }

    @Override
    public List<Task> findAll() {
        return jdbcTemplate.query("select * from task", taskRowMapper());
    }

    private int getLastRowNum(){
        String sql = "SELECT count(*) FROM task";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    private RowMapper<Task> taskRowMapper(){
        return (ResultSet rs, int rowNum) -> {
            Task task = new Task();
            task.setId(rs.getLong("id"));
            task.setNo(rs.getRow());
            task.setExplain(rs.getString("explain"));
            task.setState(rs.getString("state"));
            return task;
        };
    }
}

package com.cyber.cozastore.repository;

import com.cyber.cozastore.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<TagEntity,Integer> {

    @Query(value = "SELECT * FROM tag t inner join tag_blog tb on t.id=tb.tag_id INNER JOIN blog b on b.id=1 and tb.blog_id=?1",nativeQuery = true)
    List<TagEntity> getTagByBlogId(int id);

}

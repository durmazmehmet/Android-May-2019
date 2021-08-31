package org.csystem.samples.todoapp.repository

import org.csystem.samples.todoapp.entity.TodoInfo
import org.csystem.util.Optional

object TodoInfoRepository : ITodoInfoRepository {
    private val mTodos = ArrayList<TodoInfo>()
    private var mCount = 1


    override fun <S : TodoInfo> save(s: S): S
    {
        s.id = mCount++// otomatik artan id numarası veriyoruz
        mTodos.add(s)

        return s
    }

    override fun findAll(): MutableIterable<TodoInfo>
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findTodoInfosSortedByLastUpdate(): Iterable<TodoInfo> = mTodos.sortedByDescending { it.lastUpdate }

    override fun deleteById(p0: String?)
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll(p0: MutableIterable<TodoInfo>?)
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll()
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : TodoInfo?> saveAll(p0: MutableIterable<S>?): MutableIterable<S>
    {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun count(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAllById(p0: MutableIterable<String>?): MutableIterable<TodoInfo> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun existsById(p0: String?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findById(p0: String?): Optional<TodoInfo> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(p0: TodoInfo?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
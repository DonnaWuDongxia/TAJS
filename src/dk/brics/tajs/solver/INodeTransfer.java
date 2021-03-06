/*
 * Copyright 2012 Aarhus University
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dk.brics.tajs.solver;

import dk.brics.tajs.flowgraph.Function;
import dk.brics.tajs.flowgraph.AbstractNode;
import dk.brics.tajs.flowgraph.AbstractNodeVisitor;

/**
 * Interface for node transfer function classes.
 */
public interface INodeTransfer<BlockStateType extends IBlockState<BlockStateType, ?, ?>,
                               CallContextType extends ICallContext<?>> extends AbstractNodeVisitor<BlockStateType> {
	
	/**
	 * Applies the transfer function on the given node and input state.
	 */
	public void transfer(AbstractNode n, BlockStateType in);
	
	/**
	 * Processes ordinary and exceptional return flow when a new call edge has been added.
	 */
	public void transferReturn(AbstractNode call_node, Function callee, CallContextType caller_context, CallContextType callee_context);
}
